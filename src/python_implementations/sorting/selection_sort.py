import math

def selection_sort(array):
    largest = math.inf

    for counter in range(0 , len(array)):
        to_be_replaced_counter = counter
        for counter2 in range(to_be_replaced_counter, len(array)):
            if array[counter2] < array[to_be_replaced_counter]:
                largest = to_be_replaced_counter


        array[to_be_replaced_counter] = array[counter]
        array[counter] = min

    return  array


array = [9 , 10 , 2 , 120 , 30 , 1 , 4]

arr = selection_sort(array)
print()