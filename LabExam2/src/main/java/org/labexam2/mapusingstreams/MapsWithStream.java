package org.labexam2.mapusingstreams;


    import java.util.*;

    class MapsWithStream implements Comparable<MapsWithStream>  {
        String name;

        public MapsWithStream(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapsWithStream MapsWithStream = (MapsWithStream) o;
            return Objects.equals(name, MapsWithStream.name);
        }
        @Override
        public int compareTo(MapsWithStream other) {
            return this.name.compareTo(other.name);  // Sorting by the name property
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }


