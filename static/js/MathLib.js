//点到线的距离 (x,y) => ax+by+c=0
function ptol(a, b, c, x, y) {
    var _p = Math.sqrt(a*a + b*b);
    return ( a*x + b*y + c ) / _p;
}

//向量点乘
function pMulti(x1, y1, x2, y2 ){
    return x1*x2 + y1*y2;
}

//水平直线与直线AB的交点的x坐标，没有交点则返回null
function xSegment(y0, x1, y1, x2, y2) {

    //如果两线重合，返回线段上任一点
    if(y1 == y2) {
        if(y1 == y0) return x1;
        else return null;
    }

    return (y0-y1)*(x2-x1) / (y2-y1) + x1;
}

//垂直直线与直线AB的交点的x坐标，没有交点则返回null
function ySegment(x0, x1, y1, x2, y2) {
    //如果两线重合，返回线段上任一点
    if(x1 == x2) {
        if(x1 == x0) return y1;
        else return null;
    }

    return (x0-x1)*(y2-y1) / (x2-x1) + y1;
}

//点P到AB直线的距离
function ptoAB(xp, yp, xa, ya, xb, yb) {
    var _apLen = ptop(xp, yp, xa, ya);
    var _abLen = ptop(xa, ya, xb, yb);
    var _apPab = (xp-xa)*(xb-xa) + (yp-ya)*(yb-ya);
    var _cosPAB= _apPab / (_apLen*_abLen);
    var _sinPAB = Math.sqrt(1-_cosPAB*_cosPAB);
    return _apLen*_sinPAB;
}