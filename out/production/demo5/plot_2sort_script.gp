# Set the output file type and name
set terminal png
set output 'sort_comparison.png'

# Set plot style and labels
set title 'Comparison of Selection Sort and Insertion Sort'
set xlabel 'Experiment Number'
set ylabel 'Execution Time (ns)'

# Plot both data files
plot 'SelectionSortData.txt' using 0:1 title 'Selection Sort' with lines lw 2, \
     'InsertionSortData.txt' using 0:1 title 'Insertion Sort' with lines lw 2
