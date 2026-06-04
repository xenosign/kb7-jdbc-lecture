package org.example.user.controller;

import org.example.user.dto.UserCreateRequest;
import org.example.user.dto.UserResponse;
import org.example.user.entity.User;
import org.example.user.service.UserMybatisService;
import org.example.user.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserMybatisController {
    private static final UserService userService = new UserService();
    private static final UserMybatisService userMybatisService = new UserMybatisService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n======== 회원 관리 프로그램 ========");
            System.out.println("1. 회원 목록 조회");
            System.out.println("2. 회원 추가");
            System.out.println("3. 특정 이름이 포함 된 유저 검색");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 회원 정보 수정");
            System.out.println("6. 종료");
            System.out.print("원하는 작업 번호를 입력하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // 1. 회원 목록 조회
                List<UserResponse> users = userMybatisService.getAllUsers();

                for (UserResponse user : users) {
                    System.out.println(user);
                }
            } else if (choice == 2) {
                // 2. 회원 추가
                System.out.print("User ID : ");
                String userId = scanner.nextLine();
                System.out.print("이름 : ");
                String name = scanner.nextLine();
                System.out.print("비밀번호 : ");
                String password = scanner.nextLine();

                UserCreateRequest newUser = new UserCreateRequest();
                newUser.setUserId(userId);
                newUser.setName(name);
                newUser.setPassword(password);

                int affectedRow = userMybatisService.addUser(newUser);
                System.out.println("추가된 회원 수 : " + affectedRow);
            } else if (choice == 3) {
                // 3. 특정 이름 검색
                System.out.print("검색 할 이름 : ");
                String name = scanner.nextLine();

                List<User> result = userService.searchByName(name);
                for (User user : result) {
                    System.out.println(user);
                }
            } else if (choice == 4) {
                // 4. 회원 삭제
                System.out.print("삭제할 회원의 id(PK): ");
                int id = scanner.nextInt();

                userService.deleteUserById(id);
            } else if (choice == 5) {
                // 5. 회원 수정
                System.out.print("수정할 회원의 ID(PK): ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("새로운 User ID : ");
                String newUserId = scanner.nextLine();
                System.out.println("새로운 이름 : ");
                String newName = scanner.nextLine();
                System.out.println("새 비밀번호 : ");
                String newPassword = scanner.nextLine();

                User updateUser = new User();
                updateUser.setId(id);
                updateUser.setUserId(newUserId);
                updateUser.setName(newName);
                updateUser.setPassword(newPassword);

                userService.updateUser(updateUser);
            } else if (choice == 6) {
                System.out.println("프로그램을 종료 합니다");
                break;
            } else {
                System.out.println("잘못 된 입력입니다. 다시 입력하세요.");
            }
        }
    }
}
