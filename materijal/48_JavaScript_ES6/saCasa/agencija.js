class Trip {
    constructor({id, name, destinations = []}) {
        this.id = id;
        this.name = name;
        this.destinations = destinations;
    }

    addDestination(destination) {
        this.destinations.push(destination);
    }
}

class Destination {
    constructor({id, name}) {
        this.id = id;
        this.name = name;
    }
}

class Tour {
    constructor({id, start, end, trip,
        guide, tourists = []}) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.trip = trip;
        this.guide = guide;
        this.tourists = tourists;
    }

    addTourist(tourist) {
        this.tourists.push(tourist);
    }
}

class Person {
    constructor({id, firstName, lastName}) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Agency {
    constructor() {

    }
}