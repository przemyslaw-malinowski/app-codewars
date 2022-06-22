package org.malinowsky.the.greater.warriors;
import org.junit.Test;

public class WarriorTest {

    @Test
    public void name() {
        Warrior bruce_lee = new Warrior();
        System.out.println(bruce_lee.level()       );// => 1
        System.out.println(bruce_lee.experience()  );// => 100
        System.out.println(bruce_lee.rank()        );// => "Pushover"
        System.out.println(bruce_lee.achievements() );// => []  (as List<String>)
        System.out.println(bruce_lee.training("Defeated Chuck Norris", 9000, 1)); // => "Defeated Chuck Norris"
        System.out.println(bruce_lee.experience()  );// => 9100
        System.out.println(bruce_lee.level()       );// => 91
        System.out.println(bruce_lee.rank()        );// => "Master"
        System.out.println(bruce_lee.battle(90)   ); // => "A good fight"
        System.out.println(bruce_lee.experience()  );// => 9105
        System.out.println(bruce_lee.achievements() );// => ["Defeated Chuck Norris"]  (as List<String>)
    }

    @Test
    public void name2() {
        Warrior bruce_lee = new Warrior();
        System.out.println(bruce_lee.level()       );// => 1
        System.out.println(bruce_lee.experience()  );// => 100
        System.out.println(bruce_lee.rank()        );// => "Pushover"
        System.out.println(bruce_lee.achievements() );// => []  (as List<String>)

        System.out.println(bruce_lee.battle(4) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(2) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(4) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.training("Do the Hookie Pookie", 291, 1)); // => "Defeated Chuck Norris"
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.training("Do the Hookie Pookie", 366, 1)); // => "Defeated Chuck Norris"
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.training("Do the Hookie Pookie", 997, 1)); // => "Defeated Chuck Norris"
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(21) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(23) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.training("Do the Hookie Pookie", 795, 1)); // => "Defeated Chuck Norris"
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(32) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(31) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );


//        System.out.println(bruce_lee.training("Do the Hookie Pookie", 647, 1)); // => "Defeated Chuck Norris"
//        System.out.println(bruce_lee.experience()  );
//        System.out.println(bruce_lee.level()       );
//        System.out.println(bruce_lee.training("Do the Hookie Pookie", 221, 1)); // => "Defeated Chuck Norris"
//        System.out.println(bruce_lee.experience()  );
//        System.out.println(bruce_lee.level()       );
//        System.out.println(bruce_lee.training("Do the Hookie Pookie", 286, 1)); // => "Defeated Chuck Norris"
//        System.out.println(bruce_lee.experience()  );
//        System.out.println(bruce_lee.level()       );

//        System.out.println(bruce_lee.rank()        );// => "Master"
//        System.out.println(bruce_lee.battle(90)   ); // => "A good fight"
//        System.out.println(bruce_lee.experience()  );// => 9105
//        System.out.println(bruce_lee.achievements() );// => ["Defeated Chuck Norris"]  (as List<String>)


    }

    @Test
    public void name3() {
        Warrior bruce_lee = new Warrior();
        System.out.println(bruce_lee.level()       );// => 1
        System.out.println(bruce_lee.experience()  );// => 100
        System.out.println(bruce_lee.rank()        );// => "Pushover"
        System.out.println(bruce_lee.achievements() );// => []  (as List<String>)

        System.out.println(bruce_lee.battle(0) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(1) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(3) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(2) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(9) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(14) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(12) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(8) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(140) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(30) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(32 ));// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(39) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(61) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(83) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(100) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

        System.out.println(bruce_lee.battle(999) );// => []  (as List<String>)
        System.out.println(bruce_lee.experience()  );
        System.out.println(bruce_lee.level()       );

//        System.out.println(bruce_lee.training("Do the Hookie Pookie", 647, 1)); // => "Defeated Chuck Norris"
//        System.out.println(bruce_lee.experience()  );
//        System.out.println(bruce_lee.level()       );

    }
}