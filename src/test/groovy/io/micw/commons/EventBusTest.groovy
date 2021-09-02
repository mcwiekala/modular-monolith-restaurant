package io.micw.commons

import spock.lang.Specification

class EventBusTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    DomainEvent<String> domainEvent1 = new MessageEvent("Hello World!");
    DomainEvent<String> domainEvent2 = new MessageEvent("It's...");
    DomainEvent<String> domainEvent3 = new MessageEvent("...me!");

    def "check dispatch many events"() {
        given:
        Subscribable subscriberMock = Mock(Subscribable.class);
        subscriberMock.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))

        when:
        eventBus.register(subscriberMock)
        eventBus.dispatch(domainEvent1)
        eventBus.dispatch(domainEvent2)
        eventBus.dispatch(domainEvent3)

        then:
        1 * subscriberMock.handle(domainEvent1)
        1 * subscriberMock.handle(domainEvent2)
        1 * subscriberMock.handle(domainEvent3)
    }

    def "check dispatch many subscribers"() {
        given:
        Subscribable subscriberMock1 = Mock(Subscribable.class);
        Subscribable subscriberMock2 = Mock(Subscribable.class);
        Subscribable subscriberMock3 = Mock(Subscribable.class);

        subscriberMock1.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))
        subscriberMock2.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))
        subscriberMock3.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))

        when:
        eventBus.register(subscriberMock1)
        eventBus.register(subscriberMock2)
        eventBus.register(subscriberMock3)

        eventBus.dispatch(domainEvent1)

        then:
        eventBus.getSubscribers().size() == 3
        1 * subscriberMock1.handle(domainEvent1)
        1 * subscriberMock2.handle(domainEvent1)
        1 * subscriberMock3.handle(domainEvent1)
    }

    def "check unregister"() {
        given:
        Subscribable subscriberMock1 = Mock(Subscribable.class);
        Subscribable subscriberMock2 = Mock(Subscribable.class);

        subscriberMock1.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))
        subscriberMock2.supports() >> new HashSet<>(Collections.singletonList(MessageEvent.class))

        when:
        eventBus.register(subscriberMock1)
        eventBus.register(subscriberMock2)
        eventBus.dispatch(domainEvent1)
        eventBus.dispatch(domainEvent2)

        then:
        eventBus.getSubscribers().size() == 2
        1 * subscriberMock1.handle(domainEvent1)
        1 * subscriberMock1.handle(domainEvent2)
        1 * subscriberMock2.handle(domainEvent1)
        1 * subscriberMock2.handle(domainEvent2)

        when:
        eventBus.unregister(subscriberMock2)
        eventBus.dispatch(domainEvent3)

        then:
        eventBus.getSubscribers().size() == 1
        1 * subscriberMock1.handle(domainEvent3)
        0 * subscriberMock2.handle(domainEvent3)
    }
}
