package id.co.indivara.jdt12.json.processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import id.co.indivara.jdt12.json.entity.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonProcessor {
    public static void tulisObjectKeJson(Employee emp, String namaFile) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(namaFile), emp);

    }

    public static Employee bacaJsonKeObject(String namaFile) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(new File(namaFile), Employee.class);

        return emp;
    }

    public static void bacaArrayJsonDariFile(String namaFile) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> daftar = mapper.readValue(new File(namaFile),
                new TypeReference<List<Employee>>() {
        });
        daftar.forEach(x -> System.out.println(x));
    }

    public static void tulisDaftarObjectKeArrayJson(ArrayList<Employee> list, String namaFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(namaFile), list);
    }
}
