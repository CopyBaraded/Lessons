package Lesson_5;
/*
Task 5 Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах:
 времени их работы и стоимости.
 */

public class Park {
    private String namePark;
    public Park (String name){
        this.namePark = name;
    }
    public class SaveInfoPark {
        private String nameAttraction;
        private String time;
        private double price;
        public SaveInfoPark (String nameAttraction, String time, double price){
            this.nameAttraction = nameAttraction;
            this.time = time;
            this.price = price;
        }

        public void parkInfo(){
            System.out.println("В парке " + namePark + " пользуется спросом аттракцион "
                    + nameAttraction + " который работает в удобное время "
                    + time + " с доступной ценой " + price);
        }
    }


}
