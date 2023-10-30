set terminal pngcairo enhanced font 'Arial,12'
set output 'sorting_times.png'
set title 'Selection Sort Experiment'
set xlabel 'Experiment'
set ylabel 'Time (nanoseconds)'
set grid

plot 'data.txt' with lines
