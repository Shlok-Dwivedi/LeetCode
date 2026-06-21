class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        ans=[]
        if nums:
            prev=sys.maxsize
            curr_str=""
            start=sys.maxsize
            for i in nums:
                if prev==sys.maxsize:
                    prev=i
                    start=i
                else:
                    if i-prev==1:
                        prev=i
                    else:
                        if(start==prev):
                            ans.append(str(start))
                            prev=start=i
                        else:
                            ans.append(str(start)+"->"+str(prev))
                            prev=start=i
            if prev==start:
                ans.append(str(start))
            else:
                ans.append(str(start)+"->"+str(prev))
        return ans
        