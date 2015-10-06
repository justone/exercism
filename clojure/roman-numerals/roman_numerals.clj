(ns roman-numerals)

(defn x [n c]
  (apply str (repeat n c)))

; mapping from place to low/middle/high digit
(def place->lmh {
                 1 ["I" "V" "X"]
                 10 ["X" "L" "C"]
                 100 ["C" "D" "M"]
                 1000 ["M"]
                 })

(defn num->roman
  [n place]
  (let [[low middle high] (place->lmh place)]
    (cond
      (<= 1 n 3) (x n low)
      (<= 4 n 5) (str (x (- 5 n) low) middle)
      (<= 6 n 8) (str middle (x (- n 5) low))
      (<= 9 n 10) (str (x (- 10 n) low) high))))

(defn numerals
  [n]
  (let [nstr (str n)]
    (->>
      (map #(Integer/parseInt (str %)) nstr)  ; convert to integers
      (interleave (->> (iterate #(* % 10) 1)  ; interleave with matching powers of 10, or place
                       (take (count nstr))
                       reverse))
      (partition 2)                           ; group number with place
      (map reverse)                           ; make number first
      (map #(apply num->roman %))             ; convert to roman equivalent
      (apply str))))                          ; combine
