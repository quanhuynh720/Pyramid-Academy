import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//https://www.geeksforgeeks.org/how-to-write-data-into-excel-sheet-using-java/
//https://www.youtube.com/watch?v=ipjl49Hgsg8&list=PLUDwpEzHYYLsN1kpIjOyYW6j_GLgOyA07
//  how to create excel
//https://stackoverflow.com/questions/36220400/append-data-in-existing-excel-file-using-apache-poi-in-java
//  how to update existing excel file

public class WahooAirline {
    static Scanner scanny = new Scanner(System.in);
    private static User user = new User();
    private static BoardingPass bp = new BoardingPass();

    private static String filepath = ".\\src\\main\\excel\\userInformation.xlsx";

    public static void creatExcel() throws ParseException, IOException {
        try {
            System.out.print("\n Howdy, what is your name?: ");
            user.setName(scanny.nextLine());

            System.out.print("\n Please enter your email: ");
            user.setEmail(scanny.nextLine());

            System.out.print("\n Please enter your phone number: ");
            user.setPhoneNumber(scanny.nextLine());

            System.out.print("\n What is your gender?: ");
            user.setGender(scanny.nextLine());

            System.out.print("\n Where would you like to go?: ");
            user.setDestination(scanny.nextLine());

            System.out.print("\n What time would you like to leave for your trip?: ");
            user.setDepartureTime(scanny.nextLine());

            System.out.print("\n What day would you like to leave for your trip?: ");
            DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy"); //to read by scanner
            Date date = formatter.parse(scanny.next());
            user.setDate(date);

            System.out.print("\n Please enter your age: ");
            user.setAge(scanny.nextInt());
        } catch (Exception e) {
            System.out.print("\n Something went wrong");
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("usersInformationSheet");

        Map<String, Object[]> usersInformation = new TreeMap<String, Object[]>();
        usersInformation.put("1", new Object[] {"name", "email", "phoneNumber", "gender", "origin", "destination",
                "departureTime","date", "age"});

        usersInformation.put("2", new Object[] {
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getGender(),
                user.getOrigin(),
                user.getDestination(),
                user.getDepartureTime(),
                user.getDate(),
                user.getAge(),
        });

        Set<String> keyid = usersInformation.keySet();

        int rowid = 0;

        for (String key : keyid) {

            XSSFRow row = spreadsheet.createRow(rowid++);
            Object[] objectArr = usersInformation.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                XSSFCell cell = row.createCell(cellid++);

                if(obj instanceof String) {
                    cell.setCellValue((String)obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer)obj);
                } else if (obj instanceof Date) {
                    cell.setCellValue((Date)obj);
                }
            }
        }

        FileOutputStream outputStream = new FileOutputStream(filepath);
        workbook.write(outputStream);
        outputStream.close();

    }

    public static void addUser() throws ParseException, IOException {
        try {
            System.out.print("\n Howdy, what is your name?: ");
            user.setName(scanny.nextLine());

            System.out.print("\n Please enter your email: ");
            user.setEmail(scanny.nextLine());

            System.out.print("\n Please enter your phone number as ###-###-####: ");
            user.setPhoneNumber(scanny.nextLine());

            System.out.print("\n What is your gender?" +
                    "\n Please enter \"m\" for male, \"f\" for female, or \"o\" for others: ");
            user.setGender(scanny.nextLine());

            System.out.print("\n Where are you traveling from?: ");
            user.setOrigin(scanny.nextLine());

            System.out.print("\n Where would you like to go?: ");
            user.setDestination(scanny.nextLine());

            System.out.print("\n What time would you like to leave for your trip? Please enter as ##:## am/pm: ");
            user.setDepartureTime(scanny.nextLine());

            System.out.print("\n What day would you like to leave for your trip? Please enter as mm/dd/yyyy: ");
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //to read by scanner
            Date date = formatter.parse(scanny.next());
            user.setDate(date);

            System.out.print("\n Please enter your age: ");
            user.setAge(scanny.nextInt());
        } catch (Exception e) {
            System.out.print("\n Please follow the provided instruction on the correct input format");
        }

        FileInputStream outstream = new FileInputStream(filepath);
        XSSFWorkbook userInformation = new XSSFWorkbook(outstream);

        XSSFSheet userInformationSheet = userInformation.getSheetAt(0);
        int lastRow=userInformationSheet.getLastRowNum();
        Row row = userInformationSheet.createRow(++lastRow);

        row.createCell(0).setCellValue(user.getName());
        row.createCell(1).setCellValue(user.getEmail());
        row.createCell(2).setCellValue(user.getPhoneNumber());
        row.createCell(3).setCellValue(user.getGender());
        row.createCell(4).setCellValue(user.getOrigin());
        row.createCell(5).setCellValue(user.getDestination());
        row.createCell(6).setCellValue(user.getDepartureTime());
        row.createCell(7).setCellValue(user.getDate());
        row.createCell(8).setCellValue(user.getAge());

        outstream.close();
        FileOutputStream output_file =new FileOutputStream(new File(filepath));
        userInformation.write(output_file);
        output_file.close();

//        save();
    }

//    private static void save() {
//        try {
//            FileOutputStream outStream = new FileOutputStream(filepath);
//            sheet.getWorkbook().write(outStream);
//            outStream.close();
//            sheet = new XSSFWorkbook(new FileInputStream(new File(filepath))).getSheetAt(0);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    public static float ticketPriceCal() {
        float price = 200;
        if (user.getAge() <= 12) {
             price /= 2;
        } else if (user.getAge() >= 60) {
            price = (float) (price - (price*0.6));
        } else if (user.getGender() == "f") {
            price = (float) (price - (price*0.25));
        }
        return price;
    }

    public static void addBoardingPass() throws IOException {

        bp.setBoardingPassNumber(1);
        bp.setPrice(ticketPriceCal());

        FileInputStream outstream = new FileInputStream(filepath);
        XSSFWorkbook userInformation = new XSSFWorkbook(outstream);

        XSSFSheet boardingPassSheet = userInformation.getSheetAt(1);

        int lastRow= boardingPassSheet.getLastRowNum();
        Row row = boardingPassSheet.createRow(++lastRow);

        row.createCell(0).setCellValue(bp.getBoardingPassNumber());
        row.createCell(1).setCellValue(user.getName());
        row.createCell(2).setCellValue(user.getOrigin());
        row.createCell(3).setCellValue(user.getDestination());
        row.createCell(4).setCellValue(user.getDate());
        row.createCell(5).setCellValue(user.getDepartureTime());
        row.createCell(6).setCellValue(bp.getETA());
        row.createCell(7).setCellValue(bp.getPrice());

        outstream.close();
        FileOutputStream output_file =new FileOutputStream(new File(filepath));
        userInformation.write(output_file);
        output_file.close();

        printBoardingPass();
    }

    public static void printBoardingPass() {
        System.out.print("\n Thank you for choosing Wahoo Airline. We hope you have a safe trip!" +
                "\n Here is your boarding pass:" +
                "\n ----------------------------------------------------------------------------" +
                "\n      #" + bp.getBoardingPassNumber() + " " + user.getName() + " Date: " + user.getDate() +
                "\n      " + user.getEmail() + " " + user.getPhoneNumber() + " " + user.getGender() + " " + user.getAge() +
                "\n      Traveling from: " + user.getOrigin() + " Traveling to: " + user.getDestination() +
                "\n      Departure Time: " + user.getDepartureTime() + " ETA: " + bp.getETA() +
                "\n ----------------------------------------------------------------------------");

    }
}
