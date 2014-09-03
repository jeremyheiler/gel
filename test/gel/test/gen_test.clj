(ns gel.test.gen-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest]]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(def gen-var
  (->> (gen/tuple gen/char-alpha (gen/vector gen/string-alpha-numeric))
       (gen/fmap (fn [[c cs]] (clojure.string/join (cons c cs))))))

(def gen-var-keyword
  (->> (gen/tuple gen/char-alpha (gen/vector gen/string-alpha-numeric))
       (gen/fmap (fn [[c cs]] (keyword (string/join (cons c cs)))))))


(def filters (gen/elements ["foo" "bar" "baz"]))

(def gen-output-tag
  (gen/fmap #(str "{{ " % " }}") gen-var))

(def gen-output-tag-with-filters
  (gen/bind (gen/vector filters)
            (fn [v]
              (gen/fmap (fn [z]
                          (str "{{ " z (string/join (if (seq v)
                                                      (map (fn [x y]
                                                             (str " " x " " y))
                                                           (repeat "|")
                                                           v)
                                                      "")) " }}")) gen-var))))

;; i need the variables generated from gen-output-tag in the env
;; then i need to generate the values in the env

;; ooooooor, generate env and pick values from it for the template?

(def gen-env
  (gen/map gen-var-keyword gen/string-ascii))

(deftest test1
  (tc/quick-check 100 sort-idempotent-prop))
