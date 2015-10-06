(ns beer-song
  (:require  [clojure.string :as str]))

(defn get-words
  [n]
  (cond
    (> n 1) (str n " bottles")
    (= n 1) (str n " bottle")
    (= n 0) (str "no more bottles")))

(defn get-action
  [n]
  (cond
    (> n 1) "Take one down and pass it around"
    (= n 1) "Take it down and pass it around"
    (= n 0) "Go to the store and buy some more"))

(defn verse
  [n]
  (let [cur n
        curstr (get-words cur)
        curact (get-action cur)
        nexstr (get-words (if (= cur 0) 99 (dec n)))]
    (str (str/capitalize curstr) " of beer on the wall, " curstr " of beer.\n" curact ", " nexstr " of beer on the wall.\n")))

(defn sing
  ([s]
   (sing s 0))
  ([s e]
   (str/join "\n" (map #(verse %) (reverse (range e (inc s)))))))
