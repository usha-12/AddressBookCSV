package com.brideglabz.addressbookcsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class CSVOperation {
    File file2 = new File("C:\\Users\\User\\Desktop\\243-rfp\\AddressBookCSV\\src\\main\\java\\com\\brideglabz\\addressbookcsv\\AddressBook.csv");

    public void csvWriter(List<Contacts> contacts) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        FileWriter fileWriter = new FileWriter(file2);
        // Create Mapping Strategy to arrange the
        // column name in order
        ColumnPositionMappingStrategy mappingStrategy= new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Contacts.class);
        // Arrange column name as provided in below array.
        String[] columns = new String[]{ "count", "f_name", "l_name", "address", "city", "state", "zip", "ph_no", "email" };
        mappingStrategy.setColumnMapping(columns);
        // Creating StatefulBeanToCsv object
        StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<>(fileWriter);
        StatefulBeanToCsv writer = builder.withMappingStrategy(mappingStrategy).build();
        // Write list to StatefulBeanToCsv object
        writer.write(contacts);
        fileWriter.close();
    }
    public void csvReader() throws FileNotFoundException {
        Scanner scanner = new Scanner(file2);
        scanner.useDelimiter(",");
        while ((scanner.hasNext())) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
