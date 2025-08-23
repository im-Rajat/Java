public class PaintJob {

    public static int getBucketCount(double width, double height, double areaPerbucket, int extrabuckets)
    {
        if(width <=0 || height <= 0 || areaPerbucket <= 0 || extrabuckets < 0)
        {
            return -1;
        }

        double wallArea = width * height;
        double totalNoOfBucket = wallArea / areaPerbucket;
//        System.out.println(totalNoOfBucket);

        return ((int)Math.ceil(totalNoOfBucket) - extrabuckets);
    }

    public static int getBucketCount(double width, double height, double areaPerbucket)
    {
        if(width <=0 || height <= 0 || areaPerbucket <= 0)
        {
            return -1;
        }

        double wallArea = width * height;
        double totalNoOfBucket = wallArea / areaPerbucket;

        return (int)Math.ceil(totalNoOfBucket);
    }

    public static int getBucketCount(double area, double areaPerbucket)
    {
        if(area <= 0 || areaPerbucket <= 0)
        {
            return -1;
        }

        double totalNoOfBucket = area / areaPerbucket;

        return (int)Math.ceil(totalNoOfBucket);
    }

}
