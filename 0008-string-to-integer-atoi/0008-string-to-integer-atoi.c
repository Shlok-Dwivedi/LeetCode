int myAtoi(char* s) {
    char c;
    bool negflag=false;
    bool startedints=false;
    long double res=0;
    bool seensign=false;
    int i=0;
    while(s[i]!='\0'){
        c=s[i];
        if((c==' ' && seensign==false&& startedints==false)||(c=='_'&& seensign==false && startedints==false)){
            i++;
            continue;
        }
        else if(c=='-' && startedints==false && seensign==false){
            negflag=true;
            seensign=true;
        }
        else if(c=='+' && startedints==false && seensign==false){
            seensign=true;
        }
        else if(c>=48 && c<=57){
            res=(res*10)+(c-'0');
            startedints=true;
        }
        else{
            break;
        }
        i+=1;
    }
    if (negflag==true){
        res=0-res;
    }
     if (res > INT_MAX) {
        return INT_MAX;
    }
     if (res < INT_MIN) {
        return INT_MIN;
    }
    return res;
}