package io.pivotal.pal.tracker;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> map = new HashMap<>();
    private long currentId = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = new TimeEntry(currentId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        map.put(currentId, createdTimeEntry);
        currentId++;
        return createdTimeEntry;
    }

    public TimeEntry find(long id) {
        return map.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }


    public TimeEntry update(long id, TimeEntry timeEntry) {

        if ( map.get(id) != null) {
            TimeEntry updatedTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

            map.put(id, updatedTimeEntry);

            return updatedTimeEntry;
        }

        return null;
    }

    public void delete(long timeEntryId) {

    }
}
