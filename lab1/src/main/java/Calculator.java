import static java.lang.Math.*;

public class Calculator {
    private float epsilon;
    private int delta;
    private float a;
    private float b;
    private float c;
    private double descriminant;
    private float alpha;
    private float betha;

    public Calculator(float epsilon, int delta, float a,
                      float b, float c) {
        this.epsilon = epsilon;
        this.delta = delta;
        this.a = a;
        this.b = b;
        this.c = c;
        calsulatorDesc();
    }

    private void calsulatorDesc() {
        descriminant = 4 * (a * a - 3 * b);
        research();
    }

    private void research() {
        if (descriminant <= 0) {
            if (abs(c) < epsilon) {
                System.out.println("One root : " + 0);
            } else if (c < epsilon * (-1)) {
                int deltaSave = delta;
                while ((deltaSave * deltaSave * deltaSave +
                        a * deltaSave * deltaSave + b * deltaSave +
                        c) < 0) {
                    deltaSave += delta;
                }
                float aSave = deltaSave - delta;
                float x = (aSave + deltaSave) / 2;
                float bSave = deltaSave;
                while (abs(x * x * x + a * x * x + b * x + c) >= epsilon) {
                    if ((x * x * x + a * x * x + b * x + c) > epsilon) {
                        bSave = x;
                        x = (aSave + bSave) / 2;
                    } else if ((x * x * x + a * x * x + b * x + c) < (-1) * epsilon) {
                        aSave = x;
                        x = (aSave + bSave) / 2;
                    }
                }
                System.out.println("One root : " + x);
            } else if (c > epsilon) {
                int deltaSave = delta;
                while ((deltaSave * deltaSave * deltaSave +
                        a * deltaSave * deltaSave + b * deltaSave +
                        c) > 0) {
                    deltaSave -= delta;
                }
                float aSave = deltaSave;
                float bSave = deltaSave + delta;
                float x = (aSave + bSave) / 2;
                while (abs(x * x * x + a * x * x + b * x + c) >= epsilon) {
                    if ((x * x * x + a * x * x + b * x + c) > epsilon) {
                        bSave = x;
                        x = (aSave + bSave) / 2;
                    } else if ((x * x * x + a * x * x + b * x + c) < (-1) * epsilon) {
                        aSave = x;
                        x = (aSave + bSave) / 2;
                    }
                }
                System.out.println("One root : " + x);
            }
        } else {
            setRoots();
            // System.out.println(alpha + " " + betha);
            // this.alpha = 1;
            float fAlpha = alpha * alpha * alpha + a * alpha * alpha + b * alpha + c;
            float fBetha = betha * betha * betha + a * betha * betha + b * betha + c;
            //fBetha = -1;
            //System.out.println("fAlpha :" + fAlpha + " " + "fBetha" + fBetha);
            if (fAlpha > epsilon && fBetha > epsilon) {
                System.out.println("One root : " + setValueOneMinus(this.alpha, this.betha));
            } else if (fAlpha < (-1) * epsilon && fAlpha < (-1) * epsilon) {
                System.out.println("One root : " + setValueTwoRight(this.alpha, this.betha));
            } else if (fAlpha > epsilon && abs(fBetha) < epsilon) {
                System.out.println("Two root :  " + this.betha + " , " + setValueOneMinus(this.alpha, this.betha));
            } else if (abs(fAlpha) < epsilon && fBetha < (-1) * epsilon) {
                System.out.println("Two root :  " + this.alpha + " " + setValueTwoRight(this.alpha, this.betha));
            } else if (fAlpha > epsilon && fBetha < (-1) * epsilon) {
                System.out.println("Three root : " + setValueOneMinus(this.alpha, this.betha) + " " + setValueMiddele(this.alpha, this.betha) + " " + setValueTwoRight(this.alpha, this.betha));
            } else if (abs(fAlpha) < epsilon && abs(fBetha) < epsilon) {
                System.out.println("One root : " + (this.alpha + this.betha) / 2);
            }
        }
    }

    private double setValueOneMinus(float a, float b) {
        float deltaSave = a - delta;
        while ((deltaSave * deltaSave * deltaSave +
                this.a * deltaSave * deltaSave + this.b * deltaSave +
                this.c) > 0) {
            deltaSave = deltaSave - delta;
        }
        float aSave = deltaSave;
        float bSave = deltaSave + delta;
        float x = (aSave + bSave) / 2;
        while (abs(x * x * x + this.a * x * x + this.b * x + this.c) >= epsilon) {

            if ((x * x * x + this.a * x * x + this.b * x + this.c) >= epsilon) {
                //  System.out.println("1");
                bSave = x;
                x = (aSave + bSave) / 2;
            } else if ((x * x * x + this.a * x * x + this.b * x + this.c) < (-1) * epsilon) {
                // System.out.println("2");
                aSave = x;
                x = (aSave + bSave) / 2;
            }
            if (abs(aSave - bSave) < 0.0001) {
                return x;
            }
//            System.out.println(abs(aSave - bSave) );
//            System.out.println(abs(x * x * x + this.a * x * x + this.b * x + this.c));
//            System.out.println("asave " + aSave);
//            System.out.println("bSave " + bSave);
//            System.out.println("x " + x);
        }
        return x;
    }

    private double setValueTwoRight(float a, float b) {
        float deltaSave = b + delta;
        while ((deltaSave * deltaSave * deltaSave +
                this.a * deltaSave * deltaSave + this.b * deltaSave +
                this.c) < 0) {
            deltaSave += delta;
        }
        float aSave = deltaSave - delta;
        float bSave = deltaSave;
        float x = (aSave + bSave) / 2;
        while (abs(x * x * x + this.a * x * x + this.b * x + this.c) >= epsilon) {
            if ((x * x * x + this.a * x * x + this.b * x + this.c) > epsilon) {
                bSave = x;
                x = (aSave + bSave) / 2;
            } else if ((x * x * x + this.a * x * x + this.b * x + this.c) < (-1) * epsilon) {
                aSave = x;
                x = (aSave + bSave) / 2;
            }
            if (abs(aSave - bSave) < 0.0001) {
                return x;
            }
        }
        return x;
    }

    private double setValueMiddele(float a, float b) {
        float aSave = a;
        float bSave = b;
        float x = (aSave + bSave) / 2;
        while (abs(x * x * x + this.a * x * x + this.b * x + this.c) >= epsilon) {
            if ((x * x * x + this.a * x * x + this.b * x + this.c) > epsilon) {
                aSave = x;
                x = (aSave + bSave) / 2;
            } else if ((x * x * x + this.a * x * x + this.b * x + this.c) < (-1) * epsilon) {
                bSave = x;
                x = (aSave + bSave) / 2;
            }
        }
        if (abs(aSave - bSave) < 1) {
            return x;
        }
        return x;
    }

    private void setRoots() {
        this.alpha = (float) (((-2) * this.a + sqrt(this.descriminant)) / 6);
        this.betha = (float) (((-2) * this.a - sqrt(this.descriminant)) / 6);
        if (alpha > betha) {
            float t = alpha;
            alpha = betha;
            betha = t;
        }
//        System.out.println("alpha " + this.alpha);
//        System.out.println("betha " + this.betha);
    }

}
