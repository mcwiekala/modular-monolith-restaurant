package io.micw.commons

import spock.lang.Specification

class EventBusTest extends Specification {

    DomainEvent<String> domainEvent1 = new MessageEvent("Hello World!");
    DomainEvent<String> domainEvent2 = new MessageEvent("It's...");
    DomainEvent<String> domainEvent3 = new MessageEvent("...me!");

    def "check EventBus"() {
        given:
        Subscribable mock = Mock(Subscribable.class);
        mock.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))
        EventBus eventBus = new EventBusImpl();

        when:
        eventBus.register(mock)

        eventBus.dispatch(domainEvent1)
        eventBus.dispatch(domainEvent2)
        eventBus.dispatch(domainEvent3)
        then:
        3 * mock.handle(_)
    }
}
