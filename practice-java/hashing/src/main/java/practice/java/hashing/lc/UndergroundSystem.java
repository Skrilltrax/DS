package practice.java.hashing.lc;


import java.util.HashMap;

// LC: 1396
// https://leetcode.com/problems/design-underground-system/
class UndergroundSystem {
    class Route {
        String startStation;
        String endStation;

        public Route(String startStation, String endStation) {
            this.startStation = startStation;
            this.endStation = endStation;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = result * prime + ((startStation == null) ? 0 : startStation.hashCode());
            result = result * prime + ((endStation == null) ? 0 : endStation.hashCode());
            return result;
        }

        @Override
        public boolean equals(final Object object) {
            if (this == object) return true;
            if (object == null) return false;

            if(getClass() != object.getClass()) return false;
            final Route other = (Route) object;

            if (!this.startStation.equals(other.startStation)) return false;
            if (!this.endStation.equals(other.endStation)) return false;

            return true;
        }
    }

    class StationTime {
        String station;
        int time;

        public StationTime(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class AverageSaver {
        double averageTime;
        int size;

        public AverageSaver(double averageTime, int size) {
            this.averageTime = averageTime;
            this.size = size;
        }
    }

    HashMap<Integer, StationTime> stationMap;
    HashMap<Route, AverageSaver> averageMap;

    public UndergroundSystem() {
        stationMap = new HashMap<>();
        averageMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        StationTime st = new StationTime(stationName, t);
        stationMap.put(id, st);
    }

    public void checkOut(int id, String stationName, int t) {
        StationTime st = stationMap.remove(id);
        int timeTaken = t - st.time;

        // Map's key name is first station name + second station name
        Route route = new Route(st.station, stationName);

        // Get current average from map
        AverageSaver cas = averageMap.get(route);

        if (cas == null) {
            AverageSaver nas = new AverageSaver(timeTaken, 1);
            averageMap.put(route, nas);
            return;
        }

        // Calculate the new average
        double totalTime = cas.averageTime * cas.size;
        double newAverage = (totalTime + timeTaken) / (cas.size + 1);

        // Save the new average
        cas.averageTime = newAverage;
        cas.size = cas.size + 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route(startStation, endStation);
        AverageSaver as = averageMap.get(route);

        return as.averageTime;
    }
}
