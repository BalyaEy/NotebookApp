package org.example;

import org.example.notebook.NotebookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        NotebookService notebookService = new NotebookService();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1 - Add Note\n2 - List Notes\n3 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Print your note;");
                String noteText = scanner.nextLine();
                notebookService.addNote(noteText);

            }
            else if (choice == 2){
                notebookService.loadNotes();
                notebookService.listNotes();
            }
            else if (choice == 3) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }

}