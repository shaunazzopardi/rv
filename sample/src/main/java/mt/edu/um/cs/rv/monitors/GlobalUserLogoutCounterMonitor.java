package mt.edu.um.cs.rv.monitors;

import mt.edu.um.cs.rv.events.Event;
import mt.edu.um.cs.rv.events.LogoutEvent;
import mt.edu.um.cs.rv.monitors.results.MonitorResult;
import mt.edu.um.cs.rv.monitors.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessagingException;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dwardu on 18/01/2016.
 */
public class GlobalUserLogoutCounterMonitor implements Monitor {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalUserLogoutCounterMonitor.class);

    private Set<Class<? extends Event>> requiredEvents;
    private AtomicLong logoutCount = new AtomicLong();

    public GlobalUserLogoutCounterMonitor() {
        requiredEvents = new HashSet();
        requiredEvents.add(LogoutEvent.class);
    }

    @Override
    public String getName() {
        return "GlobalUserLogoutCounterMonitor";
    }

    @Override
    public Set<Class<? extends Event>> requiredEvents() {
        return this.requiredEvents;
    }

    @Override
    public MonitorResult handleEvent(Event event, State s) throws MessagingException {
        long l = logoutCount.incrementAndGet();
        LOGGER.info("Processing {}. Total logouts observed: {}", event.getClass().getName(), l);
        return MonitorResult.ok();
    }
}
