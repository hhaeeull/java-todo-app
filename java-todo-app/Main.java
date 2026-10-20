import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoManager manager = new TodoManager();
        boolean running = true;

        System.out.println("=== 할 일 관리 프로그램 ===");

        while (running) {
            printMenu();
            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    System.out.print("할 일 입력: ");
                    String title = scanner.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("내용을 입력해 주세요.");
                    } else {
                        manager.add(title);
                    }
                    break;
                case 2:
                    manager.printAll();
                    break;
                case 3:
                    System.out.print("완료할 번호: ");
                    manager.complete(readInt(scanner));
                    break;
                case 4:
                    System.out.print("삭제할 번호: ");
                    manager.delete(readInt(scanner));
                    break;
                case 0:
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("메뉴에 없는 번호입니다.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. 추가  2. 조회  3. 완료  4. 삭제  0. 종료");
        System.out.print("선택: ");
    }

    // 숫자가 아닌 입력이 들어와도 프로그램이 죽지 않게 처리
    private static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}