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

import entities.*;
import entities.emotionMeanings.Meaning;
import entities.emotionMeanings.UnknownMeaning;
import entities.entityBuff.Buff;
import entities.entityBuff.Stat;
import places.Place;
import places.singlePlaces.*;
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

        // Миса издала звук, который мог означать что угодно.
        Misa misa = new Misa("Миса");
        Meaning meaning = new UnknownMeaning("какое-то означающее", "что угодно");
        misa.noise(meaning);

        // Потом они помолчали, наблюдая, как Муми-мама накрывает на стол к обеду. (прим ред. к ужину)
        MumiFather father = new MumiFather("Муми-папа");
        DinnerTable dinnerTable = new DinnerTable("обеденный стол");
        Action action = new PreparingDinnerTable(dinnerTable, father);
        They they = new They("они");
        they.lookFor(action.getEvent());
        Story.FreezeStory();
        action.invokeAction();

        // Миса вспомнила чудесные локоны и вздохнула.
        Buff buff = new Buff(Stat.EXHAUSTED, new Meaning("воспоминание", "воспоминание о чудесных локонах"));
        misa.addBuff(buff);
        misa.sigh();

        // А за спиной Мисы и фрекен Снорк, среди пыльного хлама, за бумажной пальмой поблескивали внимательные и блестящие маленькие глазки.
        SuperPlace middleOfDust = new MiddleOfDust("среди пыльного хлама");
        SinglePlace paperPalma = new PaperPalma("за бумажной пальмой", middleOfDust);
        FreakenSnork snork = new FreakenSnork("фрекен Снорк");
        Homsa homsa = new Homsa("Хомса", paperPalma);
        Thing sugarStorage = new SugarStorage("сахарница");
        homsa.addItemToInventory(sugarStorage);
        snork.setLocation(middleOfDust);
        misa.setLocation(middleOfDust);
        homsa.setEyesParams(Color.DARK_GRAY, Size.SMALL);
        homsa.getHomsaEyes().shine();

        // Глазки презрительно разглядывали Мису и фрекен Снорк, а потом, скользнув по гостиному гарнитуру, остановились на маме, которая раскладывала по тарелкам кашу.
        Hall hall = new Hall("зал");
        MumiMother mom = new MumiMother("Муми-мама", hall);
        Food preparedCereal = new PreparedCereal("готовая каша");
        Plate plate = new Plate("тарелка");
        SinglePlace furnitureInHall = new Furniture("гостиный гарнитур", hall);
        Meaning despite = new Meaning("презрение", "презрительное рассмотрение");
        homsa.getHomsaEyes().examine(misa, despite);
        homsa.getHomsaEyes().examine(snork, despite);
        homsa.lookOn(furnitureInHall);
        Action momLayOutPlates = new LayingOut<>(mom, preparedCereal, plate);
        homsa.lookFor(momLayOutPlates.getEvent());

        // Глазки еще больше потемнели, а мордочка насмешливо сморщилась.
        Buff homsalaugh = new Buff(Stat.LAUGH, homsa);
        homsa.getHomsaEyes().darker();
        homsa.addBuff(homsalaugh);

        // Взяв тарелку с кашей, она поставила ее на пол под пальму.
        Unition plateWithCereal = new Unition(plate, preparedCereal);
        Floor floor = new Floor("пол под пальмой", middleOfDust);
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
        DarkCorner corner = new DarkCorner("темный угол");
        Something something = new Something("что-то", corner);
        something.peelOff();

        // Что-то серое и сморщенное прошаркало по полу гостиной, заморгало от солнечного света и затрясло седыми усами, враждебно оглядывая семью муми-троллей.
        Floor floorInHall = new Floor("пол в гостиной", hall);
        Meaning enemier = new Meaning("враждебно", "враждебный взгляд");
        something.setLocation(floorInHall);
        something.shuffle();
        something.lookOn(mom, enemier);
        something.lookOn(father, enemier);

        // Эмма не ответила, она смотрела на сыр...
        Emma emma = new Emma("Эмма");
        Cheese cheese = new Cheese("сыр");
        emma.lookOn(cheese);

        // Потом схватила ломтик сыра и сунула его в карман.
        emma.addItemToInventory(cheese.getPiece());

        // Ее взгляд блуждал по столу и остановился на блинчике.
        Pancake pancake = new Pancake("блинчик");
        emma.lookOn(dinnerTable);
        emma.lookOn(pancake);

        // Хомса умчался в кладовку.
        Pantry pantry = new Pantry("кладовка");
        homsa.setLocation(pantry);

        // Эмма так и выхватила у него рыбку из лапы и с высоко поднятой головой прошаркала в свой угол.
        EmmaCorner emmaCorner = new EmmaCorner("уголок Эммы");
        Fish unluckyfish = new Fish("несчастная рыбка, которую скоро попытаются украсть... :(");
        homsa.addItemToInventory(unluckyfish);
        Buff emmaBuff;
        if (emma.tryStealItem(homsa, unluckyfish))
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
        Meaning findingBroom = new Meaning("шум", "поиск метлы");
        emma.noise(findingBroom);
        Broom broom = new Broom("большая метла");
        emma.sweep(broom);

        // --- Start of 3rd lab work ---

        // Вечером острый запах цветущей рябины заполнил зал.
        ISmellable berry = new Rowan("рябина", "острый", true);
        hall.fillSmell(Time.EVENING, berry);

        // Птички порхали под самым потолком, охотясь за пауками
        OpenPlace underCeiling = new UnderCeiling("под самым потолком");
        Birds birds = new Birds("птчики");
        Spiders spiders = new Spiders("паучки");
        birds.setLocation(underCeiling);
        spiders.setLocation(underCeiling);
        birds.flutter();
        birds.hunt(spiders);

        // А малышка Мю повстречала на ковре в зале большого страшного муравья.
        Place hower = new Hower("ковер в зале", hall);
        Miu miu = new Miu("малышка Мю", hower);
        BigScaryAnt ant = new BigScaryAnt("большой страшный муравейка", hower);
        miu.meet(ant);

        // Только теперь все заметили, что театр плыл уже в лесу.
        ICanActionable theatre = new Theatre("театр");
        Place forest = new Forest("лес");
        Event theatreSwimming = new Event(BasicActions.SWIMMING, theatre, forest);
        Buff fear = new Buff(Stat.FEAR, emma);
        they.setLocation(forest);
        they.addBuff(fear);
        they.lockAttention(Time.ONLY_RIGHT_NOW, theatreSwimming);

        // Все пришли в сильное волнение.
        Entity.getWorried(they);

        // Забыв свой страх перед Эммой, они сгрудились у самой воды, разговаривая и размахивая лапами.
        they.removeBuff(fear);
        Place nearWater = new NearWater("около воды");
        they.setLocation(nearWater);
        they.huddle();
        they.talk();
        they.wave();

        // Они привязали дом к большой рябине.
        ICanUniteable house = new House("дом");
        ICanUniteable bigRowanTree = new BigRowanTree("большое дерево рябины");
        Unition u1 = they.attach(house, bigRowanTree);

        // Муми-папа прикрепил канат к своей палке, а палку воткнул прямо в крышу чулана.
        Rope rope = new Rope("канат");
        Stick stick = new Stick("палка");
        Unition u2 = father.attach(rope, stick);
        Lumber lumber = new Lumber("чулан");
        Roof roofOfLumber = new Roof("крыша чулана", lumber);
        father.stick(u2, roofOfLumber);

        // --- End of 3rd lab work ---

        // End of story
        System.out.println();

        // Описание состояния всех объектов
        System.out.println("Описание состояния всех объектов:");
        System.out.println("hall:" + hall);
        System.out.println("berry:" + berry);
        System.out.println("underCeiling:" + underCeiling);
        System.out.println("birds:" + birds);
        System.out.println("spiders:" + spiders);
        System.out.println("hower:" + hower);
        System.out.println("miu:" + miu);
        System.out.println("ant:" + ant);
        System.out.println("theatre:" + theatre);
        System.out.println("forest:" + forest);
        System.out.println("theatreSwimming:" + theatreSwimming);
        System.out.println("emma:" + emma);
        System.out.println("fear:" + fear);
        System.out.println("they:" + they);
        System.out.println("nearWater:" + nearWater);
        System.out.println("house:" + house);
        System.out.println("bigRowanTree:" + bigRowanTree);
        System.out.println("1-st unition:" + u1);
        System.out.println("father:" + father);
        System.out.println("rope:" + rope);
        System.out.println("stick:" + stick);
        System.out.println("2-nd unition:" + u2);
        System.out.println("lumber:" + lumber);
        System.out.println("roofOfLumber:" + roofOfLumber);
    }
}
