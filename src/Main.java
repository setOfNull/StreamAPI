import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Создаем лист из 10 юзеров
        List<User> users = List.of(new User(1L, "test102", 21, "test1@.com"),
                                   new User(2L, "test2", 36, "test2@.ru"),
                                   new User(3L, "testTt3", 19, "test3@.br"),
                                   new User(4L, "test4", 19, "test4@.com"),
                                   new User(5L, "test55", 30, "test55@.com"),
                                   new User(6L, "testTest6", 22, "testTest6@.br"),
                                   new User(7L, "test707", 25, "test707@.ru"),
                                   new User(8L, "testWWW", 16, "testWWW@.ru"),
                                   new User(9L, "test", 39, "test.com"),
                                   new User(10L, "test10", 45, "test10@.com"));

        //кидаем их в лист UserDto, с помощью стрима
        List<UserDto> userDtos = users.stream()
                .map(UserDto::new)
                .toList();

        //выводим список, отсортированный по возрасту
        userDtos.stream().sorted(Comparator.comparing(UserDto::getAge))
                .forEach(System.out::println);

        System.out.println();

         //список юзеров только с четным id
        users.stream().filter(x->x.getId()%2==0)
                .forEach(System.out::println);

        System.out.println();

        //список юзеров, с логином не длинее 5 символов
        userDtos.stream().filter(x->x.getLogin().length()<=5)
                .forEach(System.out::println);

        System.out.println();

        //юзеры с почтой заканчивающейся на .com
        userDtos.stream().filter(x->x.getEmail().contains(".com"))
                .forEach(System.out::println);


        System.out.println();

        //создаем отдельный список для вывода одних мейлов
        List<String> listOfEmails = users.stream()
                .map(User::getEmail)
                .toList();

        listOfEmails.forEach(System.out::println);

        System.out.println();

        //используем метод sum() для подсчета суммы возрастов всех пользователей
        int  sumOfAges = users.stream()
                .mapToInt(User::getAge).sum();

        System.out.println(sumOfAges);

        System.out.println();

        //помещаем лист в мэп, где ключ - это логин, а значение - почта
        Map<String, String> hashMapp = userDtos.stream()
                .collect(Collectors.toMap(UserDto::getLogin,UserDto::getEmail));
        System.out.println(hashMapp);



    }
}
