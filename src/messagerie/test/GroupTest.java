package messagerie.test;

import messagerie.models.Group;
import messagerie.models.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    private Group group;
    @BeforeEach
    void setUp() throws Exception{
        group = new Group("trouvé");
    }

    @org.junit.jupiter.api.Test
    void testAddUsers() {
        assertEquals(0, group.getUsers().size());
        User u1 = new User("J", "DOE");
        User u2 = new User("J", "SMITH");
        group.addUsers(u1, u2);
        assertEquals(2, group.getUsers().size());
        assertEquals(group, u1.getGroups().iterator().next());
        assertEquals(group, u2.getGroups().iterator().next());
        assertEquals(1, u1.getGroups().size());
        assertEquals(1, u2.getGroups().size());
        group.addUsers(u1);
        assertEquals(2, group.getUsers().size());
        group.addUsers(new User("J", "SMITH"));
        assertEquals(2, group.getUsers().size());
    }


    @org.junit.jupiter.api.Test
    void testRemoveUsers() {
        assertEquals(0,group.getUsers().size());
        User u3 = new User("J","Martin");
        User u4 = new User("J","Sacha");
        group.addUsers(u3);
        group.addUsers(u4);
        assertEquals(2,group.getUsers().size());
        group.removeUsers(u3);
        assertEquals(1,group.getUsers().size());
        assertFalse(group.getUsers().contains(u3));
        assertTrue(group.getUsers().contains(u4));
        group.removeUsers(new User("J","Sacha"));
        assertEquals(0,group.getUsers().contains(u4));
        assertFalse(group.getUsers().contains(u4));
        assertFalse(group.removeUsers(u3));
        assertFalse(group.removeUsers(new User("J","Martin")));
    }

    @org.junit.jupiter.api.Test
    void testCount() {
        assertEquals(0, group.count());
        group.getUsers().add(new User());
        assertEquals(1, group.count());
    }
}