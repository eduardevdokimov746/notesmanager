package ee.pet.notesmanager.note;

import jakarta.persistence.EnumeratedValue;

public enum BodyUnitType {
     TEXT("text"),
     LIST("list"),
     H1("header-1"),
     H2("header-2"),
     B("bold"),
     U("underline"),
     IMAGE("image"),
     URL("url");

     @EnumeratedValue
     final String slug;

     BodyUnitType(String slug) {
          this.slug = slug;
     }
}
