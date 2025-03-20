package baond.springframework.sfgpetclinic.services.map;

import baond.springframework.sfgpetclinic.model.Owner;
import baond.springframework.sfgpetclinic.model.PetType;
import baond.springframework.sfgpetclinic.services.PetService;
import baond.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by BaoND on 2025-03-20
 */
@DisplayName("Owner Map Service Test -")
public class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("First Before Each");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet - Type")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "CAT");
            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("Nested Before Each");
        }


        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
            System.out.println("Test Pet Count");
        }

        @DisplayName("Save Owners Tests -")
        @Nested
        class SaveOwnersTest {

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("Saved Owners Before Each");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Bao", "Nguyen");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }


            @DisplayName("Find Owners Tests -")
            @Nested
            class FindOwnersTest {

                @Test
                @DisplayName("Find Owner")
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }


                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound() {
                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                    System.out.println("Find owner not found");
                }
            }
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}
