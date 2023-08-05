import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<EventoBase> eventos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("================================");
            System.out.println("Google Agenda Java Console App");
            System.out.println("================================");
            System.out.println("1. Add Event");
            System.out.println("2. Add Task");
            System.out.println("3. Add Reminder");
            System.out.println("4. List Events");
            System.out.println("5. Remove Event");
            System.out.println("6. Edit Task");
            System.out.println("7. Exit");
            System.out.println("================================");
            System.out.print("Select an option (1-7): ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    eventos.add(createEvento(scanner));
                    break;
                case 2:
                    eventos.add(createTarefa(scanner));
                    break;
                case 3:
                    eventos.add(createLembrete(scanner));
                    break;
                case 4:
                    listEventos(eventos);
                    break;
                case 5:
                    removeEvento(eventos, scanner);
                    break;
                case 6:
                    editEvento(eventos, scanner);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static EventoBase createEvento(Scanner scanner) {
        System.out.print("Enter Event Title: ");
        String titulo = scanner.nextLine();

        System.out.print("Enter Event Start Date and Time (yyyy/MM/dd HH:mm): ");
        String inputDateTime = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime dataHoraInicial = LocalDateTime.parse(inputDateTime, formatter);

        System.out.print("Enter Event End Date and Time (yyyy/MM/dd HH:mm): ");
        inputDateTime = scanner.nextLine();

        LocalDateTime dataHoraFinal = LocalDateTime.parse(inputDateTime, formatter);

        System.out.print("Does the Event repeat? (true/false): ");
        boolean seRepete = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Event Location: ");
        String local = scanner.nextLine();

        System.out.print("Enter Event Description: ");
        String descricao = scanner.nextLine();

        return new Evento(titulo, dataHoraInicial, dataHoraFinal, seRepete, local, descricao);
    }

    private static EventoBase createTarefa(Scanner scanner) {
        System.out.print("Enter Task Title: ");
        String titulo = scanner.nextLine();

        System.out.print("Enter Task Date (yyyy/MM/dd): ");
        String inputDate = scanner.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate data = LocalDate.parse(inputDate, dateFormatter);

        System.out.print("Enter Task Time (HH:mm): ");
        String inputTime = scanner.nextLine();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horario = LocalTime.parse(inputTime, timeFormatter);

        System.out.print("Does the Task repeat? (true/false): ");
        boolean seRepete = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Task Description: ");
        String descricao = scanner.nextLine();

        return new Tarefa(titulo, data, horario, seRepete, descricao);
    }

    private static EventoBase createLembrete(Scanner scanner) {
        System.out.print("Enter Reminder Title: ");
        String titulo = scanner.nextLine();

        System.out.print("Enter Reminder Date and Time (yyyy/MM/dd HH:mm): ");
        String inputDateTime = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(inputDateTime, formatter);

        return new Lembrete(titulo, dataHora);
    }

    private static void listEventos(List<EventoBase> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Events:");
            for (EventoBase evento : eventos) {
                System.out.println(evento);
                System.out.println();
            }
        }
    }

    private static void removeEvento(List<EventoBase> eventos, Scanner scanner) {
        if (eventos.isEmpty()) {
            System.out.println("No events to remove.");
            return;
        }

        System.out.print("Enter the index of the event to remove (0-" + (eventos.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < eventos.size()) {
            eventos.remove(index);
            System.out.println("Event removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void editEvento(List<EventoBase> eventos, Scanner scanner) {
        if (eventos.isEmpty()) {
            System.out.println("No events to edit.");
            return;
        }

        System.out.print("Enter the index of the event to edit (0-" + (eventos.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < eventos.size()) {
            EventoBase evento = eventos.get(index);

            if (evento instanceof Evento) {
                eventos.set(index, createEvento(scanner));
            } else if (evento instanceof Tarefa) {
                eventos.set(index, createTarefa(scanner));
            } else if (evento instanceof Lembrete) {
                eventos.set(index, createLembrete(scanner));
            }

            System.out.println("Event edited successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }
}
