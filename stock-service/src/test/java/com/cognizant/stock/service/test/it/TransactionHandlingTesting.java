package com.cognizant.stock.service.test.it;


import com.cognizant.stock.model.*;
import com.cognizant.stock.persistent.*;
import com.cognizant.stock.service.StockService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.*;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Tag("service")
public class TransactionHandlingTesting extends AbstractServiceIntegrationTest {

    private OfficeRepository officeRepository;

    private StockRepository stockRepository;

    private CompanyRepository companyRepository;

    private CountryRepository countryRepository;

    private StateRepository stateRepository;

    @Autowired
    public void setStateRepository(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setOfficeRepository(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Autowired
    public void setStockRepository(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    @Test
    void addTest () {
        System.out.println(3000000000L + 2000000);
    }
    @Test
    void getStock () {
        Optional<Stock> stock = stockRepository.findById(1);
        System.out.println(stock.get());

     /* *//*  Optional<Office> officeOpt = officeRepository.findById(2);
        System.out.println(officeOpt.get());*//*

        Optional<Company> companyOpt = companyRepository.findById(7);
        Company company = companyOpt.get();
        System.out.println(company.getOffices());
        System.out.println(company.getOffices());*/
    }
    @Test
    void saveStock () {

        Stock stock = new Stock();
        Company company = new Company();
        company.setName("CGI FEDERAL");
        stock.setCompany(company);
        stock.setScripCode("CGI");
        stock.setScripName("CGI");
        stock.setScripInceptionDate("01/01/1890");
        stockRepository.save(stock);
/*        Optional<Stock> stockfromDB = stockRepository.findById(stock.getIdentifier());
        System.out.println(stockfromDB.i);*/
    }

    @Test
    void saveOffice () {
        Optional<Company> company = companyRepository.findById(7);
        /*Country country = new Country();
        country.setIso2Code("US");
        country.setIso3Code("USA");
        country.setShortName("United State");
        country.setLongName("United State of America");*/
        //countryRepository.save(country);

        Optional<Country> country = countryRepository.findById(7);
        Optional<State> statefromDB = stateRepository.findById(5);

        Office office = new Office();
        Address address = new Address();
        address.setAddressLine1("8000 Quality Circle");
        address.setState(statefromDB.get());
        address.setZip("18302");
        address.setCountry(country.get());
        office.setAddress(address);
        office.setCompany(company.get());
        office.setType(OfficeType.PRIMARY);
        office.setName("HR office");

        officeRepository.save(office);
    }

  /*  @Test
    void Transaction_Required_new () {
        List<Student> student1 = studentRepository.findAll();
        try {
            saveStudent ();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Student> student = studentRepository.findAll();
        Assert.isTrue(student != null, "student is null");
    }

    @Transactional(rollbackFor = {SQLException.class})
    void saveStudent () throws Exception {
        Student student1 = getStudent("Tanisi Pal123", 17, 70, 1);
        studentRepository.save(student1);
        throw new SQLException();
    }

    Student getStudent (String name, Integer age, Integer marks, Integer deptId) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setMarks(marks);
        student.setDepartmentId(deptId);
        return student;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    void saveDepartment () throws Exception {
        throw new Exception();
    }*/

}
