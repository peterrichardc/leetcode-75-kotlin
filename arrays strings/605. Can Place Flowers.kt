class Solution { 
    //https://leetcode.com/problems/can-place-flowers
  
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0)
            return true

        var nextValue = 0
        var planted = 0

        for (flowerIndex in 0..flowerbed.size-1) {
            val isEmptyBed = flowerbed[flowerIndex] == 0
            val isFirstRecord = flowerIndex == 0

            if (isEmptyBed) {
                if (nextValue == 1 || isFirstRecord) {
                    val isLastRecord = flowerIndex == flowerbed.size-1

                    val nextFlowerValue = if (isLastRecord) 0 else flowerbed[flowerIndex+1]
                    val previousFlowerValue = if (isFirstRecord) 0 else flowerbed[flowerIndex-1]

                    if (nextFlowerValue == 0 && previousFlowerValue == 0) {
                        flowerbed[flowerIndex] = 1
                        planted++

                        if (planted == n)
                            return true
                    }
                }
            }

            if (flowerbed[flowerIndex] == 1)
                nextValue = 0
            else
                nextValue = 1
        }

        return false
    }
}
