package kz.springframework.spring5recipeapp.converters;

import kz.springframework.spring5recipeapp.commands.NoteCommand;
import kz.springframework.spring5recipeapp.domain.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteToNoteCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NoteToNoteCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NoteToNoteCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note notes = new Note();
        notes.setId(ID_VALUE);
        notes.setRecipeNote(RECIPE_NOTES);

        //when
        NoteCommand notesCommand = converter.convert(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNote());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }

}