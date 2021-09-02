package io.micw;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;
import spock.lang.Specification;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "io.micw")
public class ModularArchitectureTest extends Specification {

    @ArchTest
    public static final ArchRule commons_should_not_depend_on_people =
            noClasses()
                    .that()
                    .resideInAPackage("..commons..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..people..");

    @ArchTest
    public static final ArchRule commons_should_not_depend_on_post =
            noClasses()
                    .that()
                    .resideInAPackage("..commons..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..post..");


}
