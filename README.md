# Galton Board

The Galton board is a device for statistical experiments named after English scientist Sir Francis
Galton. It consists of an upright board with evenly spaced nails (or pegs) driven into its upper half,
where the nails are arranged in staggered order, and a lower half divided into a number of
evenly-spaced rectangular slots. The front of the device is covered with a glass cover to allow viewing
of both nails and slots. In the middle of the upper edge, there is a funnel into which balls can be
poured. The funnel is located precisely above the central nail of the second row so that each ball, if
perfectly centered, would fall vertically and directly onto the uppermost point of this nail's. Each time
a ball hits one of the nails, it can bounce right (or left) with equal probability.

[](galton.jpg)

```
mvn clean package
```

```
java -jar GaltonBoard.jar -numThread 30000 -numBins 10
```