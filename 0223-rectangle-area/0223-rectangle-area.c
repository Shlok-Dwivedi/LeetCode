int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int x_start,x_end, y_start, y_end;
    x_start=(ax1<bx1)?bx1:ax1;
    x_end=(ax2<bx2)?ax2:bx2;
    y_start=(ay1<by1)?by1:ay1;
    y_end=(ay2<by2)?ay2:by2;
    int common_area=0;
    if (x_end > x_start && y_end > y_start) {
        common_area = (x_end - x_start) * (y_end - y_start);
    }
    int area_A=(ax2-ax1)*(ay2-ay1);
    int area_B=(bx2-bx1)*(by2-by1);
    return area_A+area_B-common_area;
}