package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    private Integer[] output;

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
        output = new Integer[0];
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        for(int i = 0; i < this.array.length; i++) {
            if (countNumberOfOccurences(this.array[i]) < maxNumberOfDuplications) {
                extractIndexValueAndAppendToOutput(i);
            }
        }
        return output;
    }
    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        for(int i = 0; i < this.array.length; i++) {
            if(countNumberOfOccurences(this.array[i]) != exactNumberOfDuplications) {
                extractIndexValueAndAppendToOutput(i);
            }
        }
        return output;
    }

    protected Integer countNumberOfOccurences(Integer indexValue){
        Integer count = 0;
        for (int i = 0; i < this.array.length; i++) {
            if(this.array[i].equals(indexValue)) count++;
        }
        return count;
    }

    public Integer[] getOutput() {
        return output;
    }

    protected void extractIndexValueAndAppendToOutput(Integer i){
        // Getting value from Input array at index
        Integer value = this.array[i];

        // create a new array that is one size bigger than current output
        Integer[] tempArray = new Integer[this.output.length + 1];

        //Copy all of the contents from the original output array into our temp array
        System.arraycopy(this.output, 0, tempArray, 0, this.output.length);

        // new value and place in the last slot of temp array
        tempArray[tempArray.length -1 ] = value;

        // no longer point to original array point to temparray
        this.output = tempArray;
    }


}
