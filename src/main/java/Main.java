import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

//        // контролируем процесс "умирания" программы, при контролируемой ошибке Exception
//        try {
//            boolean ans = isSameLen("Anna");
//            System.out.println(ans);
//        } catch (Exception e) {   // обрабатываем исключительную ситуацию; e - название ячейки куда будет класться отчет, Array...тип ячейки в stack trace
//            System.out.println("Введены не корректные данные!");  // описываем действие, когда произойдет указанный тип ошибки Array....
//            e.printStackTrace();  // выведем красное сообщение на экран
//        }

        boolean ans = isSameLen("Anna");
        System.out.println(ans);
    }

    // реализуем метод сравнения имени и фамилии по кол-ву букв в них
    // static нужен для использования метода (в рамках одного класса) без создания нового объекта!
    public static boolean isSameLen(String nameAndSurname)  { // здесь приходит связка имени и фамилии через пробел!
        System.out.println("Сравним имя и фамилию: " + nameAndSurname);
        String[] parts = nameAndSurname.split(" ");    // после разделения по пробелу получится массив из 2х элементов "имя","фамилия"

        // задаем условие для исключения, и действие в случае удовлетворения условию
        if (parts.length < 2) {
            // создадим отчет об ошибке, выберем класс RNE (не проверяемый) Начать процесс умирания - слово throw
            throw new RuntimeException("Необходимо указать имя и фамилию через пробел, " +
                                                      "а ты указал: '" + nameAndSurname + "'"
            );
        }

        String name = parts[0];                              // первый элемент разделенного массива
        String surname = parts[1];                           // второй элемент разделенного массива

//        if (name.length() == surname.length()) {
//            System.out.println("Длины имени и фамилии совпадает!");
//            return true;
//        } else {
//            System.out.println("Длина имени и фамилии НЕ совпадает!");
//            return false;
//        }
            return name.length() == surname.length(); // идентичная запись if в одну строку для стандартного boolean
    }
    // Если запустить программу с nameAndSurname= Anya, то компилятор выдаст Exception на 15 строке (когда
    // попытается присвоить значение из 1ой ячейки массива которого не существует (исключительная ситуация) - это не ошибка.
    // Так же будет фраза ArrayIndexOutOfBoundsException
}

