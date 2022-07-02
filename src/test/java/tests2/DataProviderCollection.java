package tests2;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import utilties.CSVReader;

public class DataProviderCollection {

    @DataProvider(name = "usernamePassCombo")
    public Object[][] getData(){

        return new Object[][]{
                {"afa", "dscsjdchvdhs"},
                {"majd", "sdcdscds"},
                {"amine", "vfbfdbfdbfd"},
                {"lara", "cdsc"}
        };
    }


    @DataProvider (name = "usernamePassComboRandom")
    public Object[][] getData2(){

        Faker fake = new Faker();
        return new Object[][]{
                {fake.name().username(), fake.internet().password()},
                {fake.name().username(), fake.internet().password()},
                {fake.name().username(), fake.internet().password()},
                {fake.name().username(), fake.internet().password()}
        };
    }


    @DataProvider (name = "usernamePassComboFromFile")
    public Object[][] getData3(){

        return CSVReader.readFromCSV("src/test/resources/data2.csv");
    }
}
