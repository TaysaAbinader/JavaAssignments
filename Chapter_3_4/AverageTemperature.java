package Chapter_3_4;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AverageTemperature {
   // A string representing the current row.
   // TODO: Modify this to ArrayList<String>
   private ArrayList<String> rows = new ArrayList<>();

   // Column names (from the header in the first row).
   private String[] columnNames;

   public AverageTemperature (String fileName) {
      try {
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         String row = null;
         boolean isHeader = true; // first row is a header
         do {
            row = bufferedReader.readLine();
            if (row == null) {
               break;
            }
            if (isHeader) {
               this.columnNames = row.split(";");
               isHeader = false;
               continue;
            }
            rows.add(row);
         } while (row != null);
         if (bufferedReader != null) {
            bufferedReader.close();
         }
      }
      catch (FileNotFoundException e) {
         System.err.println(e);
      }
      catch (IOException e) {
         System.err.println(e);
      }
   }

   public ArrayList<String> getColumn(String columnName) {
      int columnIndex = -1;
      for (int i = 0; i < columnNames.length; i++) {
         if (columnNames[i].equals(columnName)) {
            columnIndex = i;
            break;
         }
      }

      ArrayList<String> columnValues = new ArrayList<>();

      if (columnIndex == -1) {
         System.err.println("Error: Column name " + columnName + " not found.");
         return columnValues;
      }

      for (String row : rows) {
         String[] rowValues = row.split(";");
         columnValues.add(rowValues[columnIndex]);   
      }

      return columnValues;
   }

   public static void main(String[] args) {

      AverageTemperature fileReader = new AverageTemperature("Chapter_3_4/temploki.csv");
      
      ArrayList<String> dates = fileReader.getColumn("Aika");
      ArrayList<String> temperatures = fileReader.getColumn("UlkoTalo");

      double temperaturesSum = 0.0;
      int temperaturesCount = 0;
      for (int i = 0; i < dates.size(); i++) {
         if (dates.get(i).startsWith("01.01.2023")) {
            temperaturesSum += Double.parseDouble(temperatures.get(i).replace(",", "."));
            temperaturesCount += 1;
         }
      }

      double averageTemperature = temperaturesSum / temperaturesCount;
      System.out.println("Amount of temperature measurements in 01.01.2023: " + temperaturesCount);
      System.out.println("Sum of temperatures in 01.01.2023: " + temperaturesSum);
      System.out.printf("Average temperature in 01.01.2023: %.2f celsius\n", averageTemperature);
   }
}
