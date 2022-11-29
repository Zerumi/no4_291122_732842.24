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
import places.singlePlaces.BigRowanTree;
import places.singlePlaces.DinnerTable;
import places.singlePlaces.Hower;
import places.singlePlaces.Roof;
import places.singlePlaces.interfaces.IDinnerTable;
import places.superPlaces.isolatedPlaces.Hall;
import places.superPlaces.isolatedPlaces.House;
import places.superPlaces.isolatedPlaces.Lumber;
import places.superPlaces.isolatedPlaces.Theatre;
import places.superPlaces.openPlaces.Forest;
import places.superPlaces.openPlaces.NearWater;
import places.superPlaces.openPlaces.OpenPlace;
import places.superPlaces.openPlaces.UnderCeiling;
import story.Event;
import story.Story;
import story.Time;
import story.actions.Action;
import story.actions.BasicActions;
import story.actions.ICanActionable;
import story.actions.PreparingDinnerTable;
import things.ISmellable;
import things.Rope;
import things.Stick;
import things.berries.Rowan;
import things.unitions.ICanAttachable;
import things.unitions.Unition;


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
        IDinnerTable dinnerTable = new DinnerTable("обеденный стол");
        Action action = new PreparingDinnerTable(dinnerTable, father);
        They they = new They("они");
        they.lookFor(action.getEvent());
        Story.FreezeStory();
        action.invokeAction();

        // Миса вспомнила чудесные локоны и вздохнула.
        Buff buff = new Buff(Stat.EXHAUSTED, new Meaning("воспоминание", "воспоминание о чудесных локонах") {
            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public String getDescription() {
                return super.getDescription();
            }

            @Override
            public String getSource() {
                return super.getSource();
            }
        });
        misa.addBuff(buff);



        // Вечером острый запах цветущей рябины заполнил зал.
        Hall hall = new Hall("зал");
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
        Emma emma = new Emma("Эмма");
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
        ICanAttachable house = new House("дом");
        ICanAttachable bigRowanTree = new BigRowanTree("большое дерево рябины");
        Unition u1 = they.attach(house, bigRowanTree);

        // Муми-папа прикрепил канат к своей палке, а палку воткнул прямо в крышу чулана.
        Rope rope = new Rope("канат");
        Stick stick = new Stick("палка");
        Unition u2 = father.attach(rope, stick);
        Lumber lumber = new Lumber("чулан");
        Roof roofOfLumber = new Roof("крыша чулана", lumber);
        father.stick(u2, roofOfLumber);





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
