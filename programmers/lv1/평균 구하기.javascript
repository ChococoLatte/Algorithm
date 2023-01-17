function solution(arr) {
    var answer = 0;
    
    for(let i=0;i<arr.length;i++){
        answer+=arr[i];
    }
    
    answer = answer/arr.length;
    
    return answer;
}

// 다른 풀이
/*
function solution(arr) {
  return arr.reduce((sum, current) => sum + current) / arr.length;
}
*/
