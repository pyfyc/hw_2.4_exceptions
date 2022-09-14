import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        if (checkCredentials("alexeyv_1975", "qwerty123", "qwerty123")) {
            System.out.println("Login and password are Ok");
        }
    }

    private static boolean checkCredentials(String login, String password, String confirmPassword) {
        boolean result = false;
        try {
            if ((login.length() > 20) || !login.matches("\\w+")) {
                throw new WrongLoginException();
            }
            if ((password.length() >= 20) || !password.matches("\\w+")) {
                throw new WrongPasswordException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
            result = true;
        } catch (WrongLoginException e) {
            System.out.println("login is incorrect");
        } catch (WrongPasswordException e) {
            System.out.println("password is incorrect");
        } finally {
            return result;
        }
    }
}