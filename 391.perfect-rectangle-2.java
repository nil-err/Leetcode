class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int lenOfRac = rectangles.length;
        int[][] topPoints = new int[4][2];
        topPoints[0][0] = Integer.MAX_VALUE;
        topPoints[0][1] = Integer.MIN_VALUE;
        topPoints[1][0] = Integer.MIN_VALUE;
        topPoints[1][1] = Integer.MIN_VALUE;
        topPoints[2][0] = Integer.MAX_VALUE;
        topPoints[2][1] = Integer.MAX_VALUE;
        topPoints[3][0] = Integer.MIN_VALUE;
        topPoints[3][1] = Integer.MAX_VALUE;
        Map<List<Integer>, Integer> map = new HashMap<>();
        // Map<String, Integer> map = new HashMap<>();
        int sumArea = 0;
        for(int i = 0; i < lenOfRac; i++){
            sumArea += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
            int[][] points = new int[4][2];
            // leftTop
            points[0][0] = rectangles[i][0];
            points[0][1] = rectangles[i][3];
            // rightTop
            points[1][0] = rectangles[i][2];
            points[1][1] = rectangles[i][3];
            // leftBottom
            points[2][0] = rectangles[i][0];
            points[2][1] = rectangles[i][1];
            // rightBottom
            points[3][0] = rectangles[i][2];
            points[3][1] = rectangles[i][1];
            for(int j = 0; j < points.length; j++){
                // String point = "" + points[j][0] + "+" + points[j][1];
                // map.put(point, (map.getOrDefault(point, 0) + 1) % 2);
                List<Integer> list = Arrays.stream(points[j]).boxed().collect(Collectors.toList());
                map.put(list, (map.getOrDefault(list, 0) + 1) % 2);
            }

            topPoints[0][0] = Math.min(topPoints[0][0], points[0][0]);
            topPoints[0][1] = Math.max(topPoints[0][1], points[0][1]);
            topPoints[1][0] = Math.max(topPoints[1][0], points[1][0]);
            topPoints[1][1] = Math.max(topPoints[1][1], points[1][1]);
            topPoints[2][0] = Math.min(topPoints[2][0], points[2][0]);
            topPoints[2][1] = Math.min(topPoints[2][1], points[2][1]);
            topPoints[3][0] = Math.max(topPoints[3][0], points[3][0]);
            topPoints[3][1] = Math.min(topPoints[3][1], points[3][1]);
        }
        int Area = (topPoints[1][0] - topPoints[2][0]) * (topPoints[1][1] - topPoints[2][1]);
        if(sumArea != Area){
            return false;
        }
        for(int j = 0; j < topPoints.length; j++){
            // String point = "" + topPoints[j][0] + "+" + topPoints[j][1];
            // map.put(point, (map.getOrDefault(point, 0) + 1) % 2);
                List<Integer> list = Arrays.stream(topPoints[j]).boxed().collect(Collectors.toList());
                map.put(list, (map.getOrDefault(list, 0) + 1) % 2);
        }
        for(Map.Entry x : map.entrySet()){
            if((int)x.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
