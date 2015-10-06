(ns robot-name
  (:require [clojure.string :as string]))

(defn- rand-str [len]
  (->> (repeatedly #(char (+ 65 (rand-int 26))))
       (take len)
       (string/join)))

(defn- new-name []
  (str (rand-str 2) (rand-int 999)))

(defn robot []
  (atom (new-name)))

(defn robot-name [bot]
  @bot)

(defn reset-name [bot]
  (reset! bot (new-name)))
