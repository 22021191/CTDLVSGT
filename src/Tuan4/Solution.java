package Tuan4;

public class Solution {
    // Type your main code here.
    private int numerator;
    private int denominator;

    /**
     * Creates a new solution.
     *
     * @return a new solution.
     */
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Creates a new solution.
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
            return;
        }
        this.denominator = denominator;
    }

    Solution(int numerator, int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        this.numerator = numerator;
    }


    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public Solution reduce() {
        int i = gcd(this.numerator, this.denominator);
        numerator = numerator / i;
        denominator = denominator / i;
        return this;
    }

    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public Solution add(Solution solution) {
        int tmp = this.numerator * solution.denominator;
        int tmp0 = tmp + solution.numerator * solution.denominator;
        int tmp1 = this.denominator * solution.denominator;
        Solution result = new Solution(tmp0, tmp1);
        return result.reduce();
    }

    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public Solution subtract(Solution solution) {
        Solution result = new Solution((solution.getNumerator() * -1), solution.getDenominator());
        return this.add(result);
    }

    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public Solution multiply(Solution solution) {
        int tmp0 = this.numerator * solution.numerator;
        int tmp1 = this.denominator * solution.denominator;
        Solution result = new Solution(tmp0, tmp1);
        return result.reduce();
    }

    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public Solution divide(Solution solution) {
        if (solution.denominator == 0) {
            solution.denominator = 1;
        }
        if (solution.numerator == 0) {
            solution.numerator = 1;
        }
        int tmp = solution.numerator;
        solution.numerator = solution.denominator;
        solution.denominator = tmp;
        return multiply(solution);
    }

    /**
     * Mathf function with Solution.
     * returns the result of the function.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution tmp = (Solution) obj;
            if (this.numerator * tmp.denominator == this.denominator * tmp.numerator) {
                return true;
            }
            return false;
        }
        return false;
    }
}