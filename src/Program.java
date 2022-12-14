/* Лабораторная работа #4 ИТМО ВТ
 * (no4_291122_732842.24) от 29.11.2022, вариант #732842.24
 * Работу выполнил: Афанасьев Кирилл Александрович
 * Университет ИТМО, СУиР -- 24.03.02 СУДиН
 */

/* Текст варианта:
 *
 * Миса издала звук, который мог означать что угодно.
 * Потом они помолчали, наблюдая, как Муми-мама накрывает на стол к обеду.
 * Миса вспомнила чудесные локоны и вздохнула.
 * А за спиной Мисы и фрекен Снорк, среди пыльного хлама, за бумажной пальмой поблескивали внимательные и блестящие маленькие глазки.
 * Глазки презрительно разглядывали Мису и фрекен Снорк, а потом, скользнув по гостиному гарнитуру, остановились на маме, которая раскладывала по тарелкам кашу.
 * Глазки еще больше потемнели, а мордочка насмешливо сморщилась.
 * Взяв тарелку с кашей, она поставила ее на пол под пальму.
 * Все бросились к столу и уселись вокруг.
 * Тут он осекся и выпустил из лап сахарницу, которая со звоном упала на пол.
 * Все обернулись и посмотрели.
 * Какая-то тень отделилась от стены в темном углу.
 * Что-то серое и сморщенное прошаркало по полу гостиной, заморгало от солнечного света и затрясло седыми усами, враждебно оглядывая семью муми-троллей.
 * Она подобралась поближе к обеденному столу, но не села.
 * Эмма не ответила, она смотрела на сыр...
 * Потом схватила ломтик сыра и сунула его в карман.
 * Ее взгляд блуждал по столу и остановился на блинчике.
 * Хомса умчался в кладовку.
 * Эмма так и выхватила у него рыбку из лапы и с высоко поднятой головой прошаркала в свой угол.
 * Она долго гремела там и, вытащив наконец большую метлу, принялась усердно мести.
 * Вечером острый запах цветущей рябины заполнил зал.
 * Птички порхали под самым потолком, охотясь за пауками, а малышка Мю повстречала на ковре в зале большого страшного муравья.
 * Только теперь все заметили, что театр плыл уже в лесу.
 * Все пришли в сильное волнение.
 * Забыв свой страх перед Эммой, они сгрудились у самой воды, разговаривая и размахивая лапами.
 * Они привязали дом к большой рябине.
 * Муми-папа прикрепил канат к своей палке, а палку воткнул прямо в крышу чулана.
 * Эмма молча уставилась на него.
 * Покачав головой, она пожала плечами, презрительно фыркнула и снова принялась мести пол.
 * Муми-тролль стоял, разглядывая высоченное дерево.
 * Рои пчел и ос кружились вокруг белых цветов, а ствол красиво изогнулся, образовав вместе с веткой колыбельку, вполне пригодную для какого-нибудь малютки.
 * хочу стать больше, хочу-стать-больше, хочу-стать-больше! -- кричала малышка Мю.
 * Муми-тролль по-прежнему стоял, разглядывая зеленую крону дерева.
 * Здесь все напоминало Муми-дол.
 * Муми-тролль потихоньку насвистывал, думая о веревочной лестнице.
 * Тотчас прибежала Эмма.
 * Что-то бормоча и постукивая метлой, она заковыляла в темноту.
 * Они в растерянности смотрели ей вслед, и на какое-то мгновение семейству муми-троллей стало не по себе.
 * А потом они обо всем забыли.
 * Вечером мама постелила Муми-троллю и фрекен Снорк на дереве.
 * Потом приготовила для них корзинку с завтраком.
 * Миса тоже взглянула на дерево.
 * "Почему все так получается? -- думала она. -- Почему все так печально и сложно в моей жизни?"
 * А Муми-мама так и не смогла уснуть всю ночь.
 * Она лежала, прислушиваясь к всплескам воды под полом, и испытывала смутное беспокойство.
 * Она слышала, как Эмма шаркала взад-вперед по сцене, что-то бормоча себе под нос.
 * В лесу выл какой-то незнакомый зверь.
 */

// Доп. задание: Рефлексия.

import argCommands.Command;
import argCommands.CommandFlags.storyFlags.charactersFlags.StoryCharacterFlag;
import argCommands.Commands;
import entities.*;
import entities.emotionMeanings.Meaning;
import entities.emotionMeanings.UnknownMeaning;
import entities.entityBuff.Buff;
import entities.entityBuff.Stat;
import places.Place;
import places.singlePlaces.*;
import places.singlePlaces.trees.BigRowanTree;
import places.singlePlaces.trees.HieghestTree;
import places.superPlaces.SuperPlace;
import places.superPlaces.isolatedPlaces.*;
import places.superPlaces.openPlaces.*;
import story.Event;
import story.Size;
import story.Story;
import story.Time;
import story.actions.*;
import things.*;
import things.food.*;
import things.food.berries.Rowan;
import things.food.cheese.Cheese;
import things.unitions.ICanUniteable;
import things.unitions.Unition;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


// Согласованная объектная модель:
/* Абстракции:
 * Entity -- представляет сущность
 * Place -- место
 *  * SuperPlace -- суперместо: может содержать одиночные места (eg. Зал, который может содержать ковер)
 *  *  * IsolatedPlace -- изолированное помещение
 *  *  * OpenPlace -- открытое пространство
 *  * SinglePlace -- одиночное место (eg. Ковер в зале)
 * Thing -- вещь
 *  * Unition -- объединение ICanAttachable
 *  * Berry -- ягода
 *
 * Интерфейсы:
 * ISmellable -- Возможность иметь запах (для наполнения закрытого пространства)
 * IActionable -- Возможность совершать действие Actions
 * IAttachable -- Возможность привязывать ICanAttachable
 * ICanAttachable -- Возможность объединяться с другими ICanAttachable
 * IWorriable -- Возможность волновать
 * ISourcable -- Возможность иметь источник (entityBuff)
 *
 * Полные диаграммы см ./diagrams
 */
public class Program {
    public static void main(String[] args) {

        // Setup story objects
        System.out.println("Setting up story objects...");

        Misa misa = new Misa("Миса");
        Meaning unknownMeaning = new UnknownMeaning("какое-то означающее", "что угодно");

        MumiFather father = new MumiFather("Муми-папа");
        DinnerTable dinnerTable = new DinnerTable("обеденный стол");
        Action action = new PreparingDinnerTable(dinnerTable, father);
        They they = new They("они");

        Buff buff = new Buff(Stat.EXHAUSTED, new Meaning("воспоминание", "воспоминание о чудесных локонах"));

        SuperPlace middleOfDust = new MiddleOfDust("среди пыльного хлама");
        SinglePlace paperPalma = new PaperPalma("за бумажной пальмой", middleOfDust);
        FreakenSnork snork = new FreakenSnork("фрекен Снорк");
        Homsa homsa = new Homsa("Хомса", paperPalma);
        Thing sugarStorage = new SugarStorage("сахарница");

        Hall hall = new Hall("зал");
        MumiMother mom = new MumiMother("Муми-мама", hall);
        Food preparedCereal = new PreparedCereal("готовая каша");
        Plate plate = new Plate("тарелка");
        SinglePlace furnitureInHall = new Furniture("гостиный гарнитур", hall);
        Meaning despite = new Meaning("презрение", "презрительное рассмотрение");
        Action momLayOutPlates = new LayingOut<>(mom, preparedCereal, plate);

        Unition plateWithCereal = new Unition(plate, preparedCereal);
        Floor floor = new Floor("пол под пальмой", middleOfDust);

        Buff homsalaugh = new Buff(Stat.LAUGH, homsa);

        DarkCorner corner = new DarkCorner("темный угол");
        Something something = new Something("что-то", corner);

        Floor floorInHall = new Floor("пол в гостиной", hall);
        Meaning enemier = new Meaning("враждебно", "враждебный взгляд");

        Emma emma = new Emma("Эмма");
        Cheese cheese = new Cheese("сыр");

        Pancake pancake = new Pancake("блинчик");

        Pantry pantry = new Pantry("кладовка");

        EmmaCorner emmaCorner = new EmmaCorner("уголок Эммы");
        Fish unluckyFish = new Fish("несчастная рыбка, которую скоро попытаются украсть... :(");

        Meaning findingBroom = new Meaning("шум", "поиск метлы");
        Broom broom = new Broom("большая метла");

        ISmellable berry = new Rowan("рябина", "острый", true);

        OpenPlace underCeiling = new UnderCeiling("под самым потолком");
        Birds birds = new Birds("птчики");
        Spiders spiders = new Spiders("паучки");

        Place hower = new Hower("ковер в зале", hall);
        Miu miu = new Miu("малышка Мю", hower);
        BigScaryAnt ant = new BigScaryAnt("большой страшный муравейка", hower);

        ICanActionable theatre = new Theatre("театр");
        Place forest = new Forest("лес");
        Event theatreSwimming = new Event(BasicActions.SWIMMING, theatre, forest);
        Buff fear = new Buff(Stat.FEAR, emma);

        Place nearWater = new NearWater("около воды");

        ICanUniteable house = new House("дом");
        ICanUniteable bigRowanTree = new BigRowanTree("большое дерево рябины");

        Rope rope = new Rope("канат");
        Stick stick = new Stick("палка");

        Lumber lumber = new Lumber("чулан");
        Roof roofOfLumber = new Roof("крыша чулана", lumber);

        Meaning silenceMeaning = new Meaning("молча", "молчаливое означающее");

        MumiThroll mumiThroll = new MumiThroll("Муми-тролль");
        HieghestTree hieghestTree = new HieghestTree("высоченное дерево");

        Flowers flowers = new Flowers("цветы", Color.WHITE);
        Hive hive = new Hive("рой пчел", flowers);

        Meaning confuseMeaning = new Meaning("растерянность", "растерянный взгляд");

        BedSheet bedSheet = new BedSheet("постельное белье");

        System.out.println("Object creating part ended");

        // Start command manager
        System.out.println("Welcome to the Mumi-throll story. You are in the commandline console manager: story setup mode.");
        System.out.println("Use \"help\" for get list of supported commands");
        while (Command.getCommangManagerRunning()) {
            try {
                if (args.length > 0) {
                    Commands.Parser.parseWithArguments(args).invokeCommand();
                }
                String[] commandArgs;
                Scanner scanner = new Scanner(System.in);
                commandArgs = scanner.nextLine().split(" ");
                Commands.Parser.parseWithArguments(commandArgs).invokeCommand();
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println("COMMAND NOT FOUND! " + ex.getMessage());
            }
            catch (NullPointerException ex)
            {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        // run the story. Rpc tournament
        RPCTournament tournament = new RPCTournament(StoryCharacterFlag.getCurrentCharacters().toArray(new Entity[]{}));
        tournament.invokeAction();

        // Миса издала звук, который мог означать что угодно.
        misa.noise(unknownMeaning);

        // Потом они помолчали, наблюдая, как Муми-мама накрывает на стол к обеду. (прим ред. к ужину)
        they.lookFor(action.getEvent());
        Story.FreezeStory(500);
        action.invokeAction();

        // Миса вспомнила чудесные локоны и вздохнула.
        misa.addBuff(buff);
        misa.sigh();

        // А за спиной Мисы и фрекен Снорк, среди пыльного хлама, за бумажной пальмой поблескивали внимательные и блестящие маленькие глазки.
        homsa.addItemToInventory(sugarStorage);
        snork.setLocation(middleOfDust);
        misa.setLocation(middleOfDust);
        homsa.setEyesParams(Color.DARK_GRAY, Size.SMALL);
        homsa.getHomsaEyes().shine();

        // Глазки презрительно разглядывали Мису и фрекен Снорк, а потом, скользнув по гостиному гарнитуру, остановились на маме, которая раскладывала по тарелкам кашу.
        homsa.getHomsaEyes().examine(misa, despite);
        homsa.getHomsaEyes().examine(snork, despite);
        homsa.lookOn(furnitureInHall);
        homsa.lookFor(momLayOutPlates.getEvent());

        // Глазки еще больше потемнели, а мордочка насмешливо сморщилась.
        homsa.getHomsaEyes().darker();
        homsa.addBuff(homsalaugh);

        // Взяв тарелку с кашей, она поставила ее на пол под пальму.
        plateWithCereal.setLocation(mom, floor);

        // Все бросились к столу и уселись вокруг.
        they.setLocation(dinnerTable);

        // Тут он осекся и выпустил из лап сахарницу, которая со звоном упала на пол.
        homsa.removeItemFromInventory(sugarStorage);
        ((IDestroyable)sugarStorage).destroy(); // add reason?

        // Все обернулись и посмотрели.
        they.rotate(180);
        they.lookOn(floor);

        // Какая-то тень отделилась от стены в темном углу.
        something.peelOff();

        // Что-то серое и сморщенное прошаркало по полу гостиной, заморгало от солнечного света и затрясло седыми усами, враждебно оглядывая семью муми-троллей.
        something.setLocation(floorInHall);
        something.shuffle();
        something.lookOn(mom, enemier);
        something.lookOn(father, enemier);

        // Эмма не ответила, она смотрела на сыр...
        emma.lookOn(cheese);

        // Потом схватила ломтик сыра и сунула его в карман.
        emma.addItemToInventory(cheese.getPiece());

        // Ее взгляд блуждал по столу и остановился на блинчике.
        emma.lookOn(dinnerTable);
        emma.lookOn(pancake);

        // Хомса умчался в кладовку.
        homsa.setLocation(pantry);

        // Эмма так и выхватила у него рыбку из лапы и с высоко поднятой головой прошаркала в свой угол.
        homsa.addItemToInventory(unluckyFish);
        Buff emmaBuff;
        if (emma.tryStealItem(homsa, unluckyFish))
        {

            emmaBuff = new Buff(Stat.PRIDE, () -> "Украденная вещь");
        }
        else
        {
            emmaBuff = new Buff(Stat.ANGER, () -> "Не украденная вещь");
        }
        emma.addBuff(emmaBuff);
        emma.setLocation(emmaCorner);
        emma.shuffle();

        // Она долго гремела там и, вытащив наконец большую метлу, принялась усердно мести.
        emma.noise(findingBroom);
        emma.sweep(broom);

        // --- Start of 3rd lab work ---

        // Вечером острый запах цветущей рябины заполнил зал.
        hall.fillSmell(Time.EVENING, berry);

        // Птички порхали под самым потолком, охотясь за пауками
        birds.setLocation(underCeiling);
        spiders.setLocation(underCeiling);
        birds.flutter();
        birds.hunt(spiders);

        // А малышка Мю повстречала на ковре в зале большого страшного муравья.
        miu.meet(ant);

        // Только теперь все заметили, что театр плыл уже в лесу.
        they.setLocation(forest);
        they.addBuff(fear);
        they.lockAttention(Time.ONLY_RIGHT_NOW, theatreSwimming);

        // Все пришли в сильное волнение.
        Entity.getWorried(they);

        // Забыв свой страх перед Эммой, они сгрудились у самой воды, разговаривая и размахивая лапами.
        they.removeBuff(fear);
        they.setLocation(nearWater);
        they.huddle();
        they.talk();
        they.wave();

        // Они привязали дом к большой рябине.
        they.attach(house, bigRowanTree);

        // Муми-папа прикрепил канат к своей палке, а палку воткнул прямо в крышу чулана.
        Unition u2 = father.attach(rope, stick);
        father.stick(u2, roofOfLumber);

        // --- End of 3rd lab work ---

        // Эмма молча уставилась на него.
        emma.lookOn(father, silenceMeaning);

        // Покачав головой, она пожала плечами, презрительно фыркнула и снова принялась мести пол.
        emma.shakeHead();
        emma.shrug();
        emma.snort(despite);
        emma.sweep(broom);

        // Муми-тролль стоял, разглядывая высоченное дерево.
        mumiThroll.lookOn(hieghestTree);

        // Рои пчел и ос кружились вокруг белых цветов, а ствол красиво изогнулся, образовав вместе с веткой колыбельку, вполне пригодную для какого-нибудь малютки.
        final int BEAUTIFUL_ROTATION_ANGLE = 30;
        hive.whirl();
        try {
            hieghestTree.getTrunk().curve(BEAUTIFUL_ROTATION_ANGLE);
        }
        catch (Exception ex)
        {
            System.out.println("Упс... " + ex.getMessage());
            System.out.println("Мы восстанавливаем сцену для продолжения истории... :(");
            Story.FreezeStory(7000);
        }

        // хочу стать больше, хочу-стать-больше, хочу-стать-больше! -- кричала малышка Мю.
        miu.loud("хочу стать больше, хочу-стать-больше, хочу-стать-больше!");

        // Муми-тролль по-прежнему стоял, разглядывая зеленую крону дерева.
        mumiThroll.lookOn(hieghestTree.getCrown());

        // Муми-тролль потихоньку насвистывал, думая о веревочной лестнице.
        mumiThroll.whistle();
        mumiThroll.think("Веревочная лестница.... Наверное ее можно сделать из веревок....");

        // Тотчас прибежала Эмма.
        emma.runTo(Time.ONLY_RIGHT_NOW, mumiThroll.getLocation());

        // Что-то бормоча и постукивая метлой, она заковыляла в темноту.
        emma.mutter();
        emma.knock(broom);
        emma.setLocation(new UnknownLocation("неизвестное миру сему место"));

        // Они в растерянности смотрели ей вслед, и на какое-то мгновение семейству муми-троллей стало не по себе.
        Buff theyConfuse = new Buff(Stat.CONFUSE, emma);
        they.addBuff(theyConfuse);
        they.lookOn(emma, confuseMeaning);

        // А потом они обо всем забыли.
        Story.FreezeStory(1000);
        they.removeBuff(theyConfuse);

        // Вечером мама постелила Муми-троллю и фрекен Снорк на дереве.
        mom.layDown(bedSheet, hieghestTree, Time.EVENING, mumiThroll, snork);

        // Миса тоже взглянула на дерево.
        misa.lookOn(hieghestTree);

        // "Почему все так получается? -- думала она. -- Почему все так печально и сложно в моей жизни?"
        // прим. ред: согласен
        misa.think("\"Почему все так получается? Почему все так печально и сложно в моей жизни?\"");

        // бонус от студента
        Class<Program> cl = Program.class;
        try {
            System.out.println(ResourceAccess.readFromInputStream(cl.getResourceAsStream("image-1670351657600,12.txt")));
        }
        catch (IOException ignored) {}

        // End of story
        System.out.println();
    }

    public static class ResourceAccess
    {
        private static String readFromInputStream(InputStream inputStream)
                throws IOException {
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
            }
            return resultStringBuilder.toString();
        }
    }
}
