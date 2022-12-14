package argCommands.CommandFlags.storyFlags.objectsFlags.getObjectFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;
import com.sun.management.HotSpotDiagnosticMXBean;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

public class GetObjectsCommand extends CommandFlag {
    // story -og
    // story -o -g
    // story --objects --get

    private static GetObjectsCommand singleToneMoment;

    private GetObjectsCommand()
    {

    }

    public static CommandFlag getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new GetObjectsCommand();
        }
        return singleToneMoment;
    }

    @Override
    public String getName() {
        return "story -o -g";
    }

    @Override
    public String getDescription() {
        return "Makes a heapdump of created objects";
    }

    @Override
    public String getUsage() {
        return "story -o -g";
    }

    @Override
    public ArrayList<String> getParams() {
        return new ArrayList<>(){{
            add("This command doesn't operating parameters");
        }};
    }
    @Override
    public ICommandFlags[] getFlags() {

        return new ICommandFlags[] {};
    }

    @Override
    public void invokeCommand(String[] args) {
        // reflection
        class HeapDumper {

            private static final String HOTSPOT_BEAN_NAME =
                    "com.sun.management:type=HotSpotDiagnostic";
            private static volatile HotSpotDiagnosticMXBean hotspotMBean;

            static void dumpHeap(String fileName, boolean live) {
                initHotspotMBean();
                try {
                    hotspotMBean.dumpHeap(fileName, live);
                } catch (RuntimeException re) {
                    throw re;
                } catch (Exception exp) {
                    throw new RuntimeException(exp);
                }
            }

            private static void initHotspotMBean() {
                if (hotspotMBean == null) {
                    synchronized (HeapDumper.class) {
                        if (hotspotMBean == null) {
                            hotspotMBean = getHotspotMBean();
                        }
                    }
                }
            }

            private static HotSpotDiagnosticMXBean getHotspotMBean() {
                try {
                    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
                    HotSpotDiagnosticMXBean bean =
                            ManagementFactory.newPlatformMXBeanProxy(server,
                                    HOTSPOT_BEAN_NAME, HotSpotDiagnosticMXBean.class);
                    return bean;
                } catch (RuntimeException re) {
                    throw re;
                } catch (Exception exp) {
                    throw new RuntimeException(exp);
                }
            }
        }

        String fileName = "heap.hprof";
        boolean live = true; // only reachable object - true, all objects - false
        try {
            HeapDumper.dumpHeap(fileName, live);
            System.out.println("Heapdump done! You can find it in the main jar directory.");
        }
        catch (Exception e)
        {
            System.out.println("story -o -i: Exception: " + e.getMessage());
        }
    }
}
