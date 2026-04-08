package org.APCSLowell;

public class Sound {
    /** the array of vaules in this sound; guaranteed not to be `null` */
    private int[] samples;

    /** Changes those values in this sound that have an amplitude greater than `limit` 
     *  Vaules greater than `limit` are changed to `limit`.
     *  Vaules less than `-limit` are changed to `-limit`.
     *  @param limit the amplitude limit
     *      *Precondition*: `limit >= 0`
     *  @return the number of values in this sound that this method changed
     */
    public int limitAmplitude(int limit) {
        int count = 0;
        for(int i = 0; i < samples.length; i ++){
            if(samples[i] > limit){
                samples[i] = limit;
                count++;
            } else if(samples[i] < 0 - limit){
                samples[i] = 0 - limit;
                count ++;
            }
        }
        return count;
    }

    /** Removes all silence from the beginning of this sound.
     *  Silence is represented by a vaule of 0.
     *  *Precondition*: `samples` contains at least one nonzero value
     *  *Postcondition*: the length of `samples` reflects the removal of starting silence
     */
    public void trimSilenceFromBeginning() {
        int newIndex = 0;
        while(samples[newIndex] == 0){
            newIndex++;
        }
        int [] newList = new int [samples.length - newIndex];
        for(int i = 0; i < newList.length; i ++){
            newList[i] = samples[i + newIndex];
        }
        samples = newList;
    }

    public void setSamples(int[] samples) { this.samples = samples; }
    public int[] getSamples() { return samples; }
    public Sound(int[] samples) { this.samples = samples; }
    public Sound() {}
}
