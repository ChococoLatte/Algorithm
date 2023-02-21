function solution(price, money, count) {
    let tot=0;
    
    for(let i=1;i<=count;i++){
        tot+=price*i;
    }
    
    if(money-tot>=0) return 0;
    else return tot-money;
    
}
