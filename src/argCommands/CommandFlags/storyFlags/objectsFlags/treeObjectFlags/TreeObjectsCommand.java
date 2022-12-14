package argCommands.CommandFlags.storyFlags.objectsFlags.treeObjectFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TreeObjectsCommand extends CommandFlag {

    private static TreeObjectsCommand singleToneMoment;

    private TreeObjectsCommand(){}

    public static CommandFlag getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new TreeObjectsCommand();
        }
        return singleToneMoment;
    }
    @Override
    public ICommandFlags[] getFlags() {
        return new ICommandFlags[]{};
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public ArrayList<String> getParams() {
        return null;
    }

    @Override
    public void invokeCommand(String[] args) {
        try {
            new ResourceWalker().walk(".\\");
        }
        catch (Exception ex)
        {
            System.out.println("story -o -t: Exception: " + ex.getMessage());
        }

    }

    class ResourceWalker
    {
        private static ConcurrentMap<String, Object> locks = new ConcurrentHashMap<>();

        public void walk(String path) throws Exception {
            Files.walk(Paths.get(path)).forEach(System.out::println);
        }

        private void safeWalkJar(String path, URI uri) throws Exception {

            synchronized (getLock(uri)) {
                // this'll close the FileSystem object at the end
                try (FileSystem fs = getFileSystem(uri)) {
                    Files.walk(fs.getPath(path)).forEach(System.out::println);
                }
            }
        }

        private Object getLock(URI uri) {

            String fileName = parseFileName(uri);
            locks.computeIfAbsent(fileName, s -> new Object());
            return locks.get(fileName);
        }

        private String parseFileName(URI uri) {

            String schemeSpecificPart = uri.getSchemeSpecificPart();
            return schemeSpecificPart.substring(0, schemeSpecificPart.indexOf("!"));
        }

        private FileSystem getFileSystem(URI uri) throws IOException {

            try {
                return FileSystems.getFileSystem(uri);
            } catch (FileSystemNotFoundException e) {
                return FileSystems.newFileSystem(uri, Collections.<String, String>emptyMap());
            }
        }
    }
}
