import java.util.ArrayList;

public class TodoManager {
    private ArrayList<Todo> todos = new ArrayList<>();

    // 추가
    public void add(String title) {
        todos.add(new Todo(title));
        System.out.println("추가되었습니다: " + title);
    }

    // 전체 조회
    public void printAll() {
        if (todos.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ". " + todos.get(i));
        }
    }

    // 완료 처리 (사용자는 1번부터 입력하므로 index는 number - 1)
    public void complete(int number) {
        if (!isValid(number)) {
            System.out.println("올바른 번호가 아닙니다.");
            return;
        }
        todos.get(number - 1).markDone();
        System.out.println("완료 처리되었습니다.");
    }

    // 삭제
    public void delete(int number) {
        if (!isValid(number)) {
            System.out.println("올바른 번호가 아닙니다.");
            return;
        }
        Todo removed = todos.remove(number - 1);
        System.out.println("삭제되었습니다: " + removed.getTitle());
    }

    // 번호 유효성 검사
    private boolean isValid(int number) {
        return number >= 1 && number <= todos.size();
    }
}